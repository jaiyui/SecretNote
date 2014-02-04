package net.secretnote.web.secretKey;

import net.secretnote.web.common.Utils;
import net.secretnote.web.session.SessionDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SecretKeyServiceImpl implements SecretKeyService {

	@Autowired SecretKeyDAO dao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(int useridx, String key) {
		SecretKey secretKey = new SecretKey();
		secretKey.userIdx = useridx;
		secretKey.key = Utils.encodeMD5(key);

		dao.create(secretKey);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(int useridx) {
		dao.delete(useridx);
	}

	@Override
	@Transactional(readOnly=true)
	public Boolean verify(int useridx, String key) {
		key = Utils.encodeMD5(key);
		return dao.verify(useridx, key);
	}

}
