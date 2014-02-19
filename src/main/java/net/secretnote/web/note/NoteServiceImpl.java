package net.secretnote.web.note;

import java.util.List;
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
		dao.create(note);
	}

	@Override
	@Transactional(readOnly=true)
	public Note read(int idx) {
		Note note = dao.read(idx);
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
