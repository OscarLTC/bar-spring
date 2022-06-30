package blc.idat.apiblc.security;

public interface IEncrypt {

    String encryptPassword(String password);

    boolean verifyPassword(String originalPassword, String password);

}
