package net.secretnote.web.note;

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
public class NoteServiceImpl implements NoteService {

	@Autowired NoteDAO dao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Note note) {
		try {
			note.note = AES256.AES_Encode(note.note);
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
		dao.create(note);
	}

	@Override
	@Transactional(readOnly=true)
	public Note read(int idx) {
		Note note = dao.read(idx);
		try {
			note.note = AES256.AES_Decode(note.note);
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
		return note;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Note note) {
		dao.update(note);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(int idx) {
		dao.delete(idx);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Note> list(int userIdx, String tag) {
		return dao.list(userIdx, tag);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Note> search(int userIdx, String tags) {
		return dao.search(userIdx, tags);
	}

}
