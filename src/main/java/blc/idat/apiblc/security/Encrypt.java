package blc.idat.apiblc.security;



import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encrypt implements IEncrypt {

    BCryptPasswordEncoder passwordEncoded = new BCryptPasswordEncoder();

    @Override
    public String encryptPassword(String password) {

        String passwordEncrypt = passwordEncoded.encode(password);
        return passwordEncrypt;

    }

    @Override
    public String verifyPassword(String originalPassword, String password) {
        return null;
    }
}
