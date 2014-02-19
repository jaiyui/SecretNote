package net.secretnote.web.post;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @brief 	Post DAO Mybatis 
 * @author 	성낙천
 * @version 1.0
 * @date    생성일: 2014.02.12 
 * @date    수정일: 2014.02.12
 * @remark
 */
@Repository
@Transactional
public class PostDAOMybatis implements PostDAO {

	@Autowired SqlSession sqlSession;
	
	@Override
	public void create(Post post) {
		sqlSession.insert("Post.create", post);
	}

	@Override
	public Post read(int idx) {
		return sqlSession.selectOne("Post.read", idx);
	}

	@Override
	public void update(Post post) {
		sqlSession.update("Post.update", post);
	}

	@Override
	public void delete(int idx) {
		sqlSession.delete("Post.delete", idx);
	}

	@Override
	public List<Post> list(int noteIdx, int page, int perPage) {
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("noteIdx", String.valueOf(noteIdx));
		param.put("page", String.valueOf(page));
		param.put("perPage", String.valueOf(perPage));
		
		return sqlSession.selectList("Post.list", param);
	}

}
