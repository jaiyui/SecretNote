package net.secretnote.web.noteJoin;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NoteJoinServiceImpl implements NoteJoinService {

	@Autowired NoteJoinDAO dao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(NoteJoin noteJoin) {
		dao.create(noteJoin);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(int idx) {
		dao.delete(idx);
	}

	@Override
	@Transactional(readOnly=true)
	public List<NoteJoin> list(int noteIdx) {
		return dao.list(noteIdx);
	}

	@Override
	public void up(int idx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void down(int idx) {
		// TODO Auto-generated method stub
		
	}

}
