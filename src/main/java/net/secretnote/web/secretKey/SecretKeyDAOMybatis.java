package net.secretnote.web.secretKey;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @brief 	SecretKey DAO Mybatis 
 * @author 	성낙천
 * @version 1.0
 * @date    생성일: 2014.02.04 
 * @date    수정일: 2014.02.04
 * @remark
 */
@Repository
@Transactional
public class SecretKeyDAOMybatis implements SecretKeyDAO {

	@Autowired SqlSession sqlSession;

	@Override
	public void create(SecretKey secretKey) {
		sqlSession.delete("SecretKey.delete", secretKey.userIdx);
		sqlSession.insert("SecretKey.create", secretKey);
	}

	@Override
	public void delete(int useridx) {
		sqlSession.delete("SecretKey.delete", useridx);
	}

	@Override
	public Boolean verify(int useridx, String key) {
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("useridx", String.valueOf(useridx));
		param.put("key", key);

		int foundCount = sqlSession.selectOne("SecretKey.verify", param);
		return (foundCount > 0) ? true : false;
	}


}
