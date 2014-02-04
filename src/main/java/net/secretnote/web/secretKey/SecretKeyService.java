package net.secretnote.web.secretKey;

public interface SecretKeyService {
	void create(int useridx, String key);
	void delete(int useridx);
	Boolean verify(int useridx, String key);

}
