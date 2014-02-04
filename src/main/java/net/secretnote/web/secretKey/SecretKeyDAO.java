package net.secretnote.web.secretKey;

public interface SecretKeyDAO {
	void create(SecretKey secretKey);
	void delete(int useridx);
	Boolean verify(int useridx, String key);
}
