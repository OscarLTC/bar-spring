package blc.idat.apiblc.security;

public interface IEncrypt {

    String encryptPassword(String password);

    String verifyPassword(String originalPassword, String password);

}
