package net.secretnote.web.post;

import java.util.List;

public interface PostDAO {
	void create(Post post);
	Post read(int idx);
	void update(Post post);
	void delete(int idx);
	List<Post> list(int noteIdx, int page, int perPage);
}
