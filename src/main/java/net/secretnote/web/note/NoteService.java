package net.secretnote.web.note;

import java.util.List;

public interface NoteService {
	void create(Note note);
	Note read(int idx);
	void update(Note note);
	void delete(int idx);
	List<Note> list(int userIdx, String tag);
	List<Note> search(int userIdx, String tags);
}
