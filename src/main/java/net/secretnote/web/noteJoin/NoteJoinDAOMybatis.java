package net.secretnote.web.noteJoin;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @brief 	NoteJoin DAO Mybatis 
 * @author 	성낙천
 * @version 1.0
 * @date    생성일: 2014.02.05 
 * @date    수정일: 2014.02.05
 * @remark
 */
@Repository
@Transactional
public class NoteJoinDAOMybatis implements NoteJoinDAO {

	@Autowired SqlSession sqlSession;
	
	@Override
	public void create(NoteJoin noteJoin) {
		sqlSession.insert("NoteJoin.create", noteJoin);
	}

	@Override
	public void delete(int idx) {
		sqlSession.delete("NoteJoin.delete", idx);
	}

	@Override
	public List<NoteJoin> list(int noteIdx) {
		return sqlSession.selectList("NoteJoin.list", noteIdx);
	}

	@Override
	public void changeOrder(int idx, int order) {
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("idx", String.valueOf(idx));
		param.put("order", String.valueOf(order));

		sqlSession.delete("NoteJoin.changeOrder", idx);
	}
}
