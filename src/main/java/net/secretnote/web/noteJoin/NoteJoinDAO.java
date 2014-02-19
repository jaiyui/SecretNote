package net.secretnote.web.noteJoin;

import java.util.List;

public interface NoteJoinDAO {
	void create(NoteJoin noteJoin);
	void delete(int idx);
	List<NoteJoin> list(int noteIdx);
	void changeOrder(int idx, int order);
}
