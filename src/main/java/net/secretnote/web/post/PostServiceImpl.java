package net.secretnote.web.post;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import net.secretnote.web.common.AES256;
import net.secretnote.web.secretKey.SecretKeyDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PostServiceImpl implements PostService {

	@Autowired PostDAO dao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Post post) {
		try {
			post.content = AES256.AES_Encode(post.content);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao.create(post);
	}

	@Override
	@Transactional(readOnly=true)
	public Post read(int idx) {
		Post post = dao.read(idx);
		try {
			post.content = AES256.AES_Decode(post.content);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return post;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Post post) {
		dao.update(post);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(int idx) {
		dao.delete(idx);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Post> list(int noteIdx, int page, int perPage) {
		return dao.list(noteIdx, page, perPage);
	}

}
