package blc.idat.apiblc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ApiblcApplication {

    public static void main(String[] args) {

        SpringApplication.run(ApiblcApplication.class, args);
    }

}
