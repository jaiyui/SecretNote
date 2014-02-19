package net.secretnote.web.post;

import java.util.Date;

public class Post {
	int idx;
	int noteIdx;
	int userIdx;
	Date regDate;
	String content;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getNoteIdx() {
		return noteIdx;
	}
	public void setNoteIdx(int noteIdx) {
		this.noteIdx = noteIdx;
	}
	public int getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
