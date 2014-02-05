package net.secretnote.web.note;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @brief 	Note DAO Mybatis 
 * @author 	성낙천
 * @version 1.0
 * @date    생성일: 2014.02.05 
 * @date    수정일: 2014.02.05
 * @remark
 */
@Repository
@Transactional
public class NoteDAOMybatis implements NoteDAO {

	@Autowired SqlSession sqlSession;
	
	@Override
	public void create(Note note) {
		sqlSession.insert("Note.create", note);
	}

	@Override
	public Note read(int idx) {
		return sqlSession.selectOne("Note.read", idx);
	}

	@Override
	public void update(Note note) {
		sqlSession.update("Note.update", note);
	}

	@Override
	public void delete(int idx) {
		sqlSession.delete("Note.delete", idx);
	}

	@Override
	public List<Note> list(int userIdx, String tag) {
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("userIdx", String.valueOf(userIdx));
		param.put("tag", tag);
		
		return sqlSession.selectList("Note.list", param);
	}

	@Override
	public List<Note> search(int userIdx, String tags) {
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("userIdx", String.valueOf(userIdx));
		param.put("tags", tags);
		
		return sqlSession.selectList("Note.search", param);
	}

}
