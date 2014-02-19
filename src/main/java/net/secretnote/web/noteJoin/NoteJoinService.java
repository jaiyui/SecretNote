package net.secretnote.web.noteJoin;

import java.util.List;

public interface NoteJoinService {
	void create(NoteJoin noteJoin);
	void delete(int idx);
	List<NoteJoin> list(int noteIdx);
	void up(int idx);
	void down(int idx);
}
