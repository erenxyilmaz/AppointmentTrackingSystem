package com.distdemo3.appoint;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/appointments/auth")
public class AuthCont {
    private static final Logger logger = LoggerFactory.getLogger(AuthCont.class);

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login credentials) {
        logger.info("Login attempt with username: {}", credentials.getUsername());


        //public ResponseEntity<?> login(@RequestBody LoginCredentials credentials) {
        // Örnek kullanıcı adı ve şifre
        final String demoUsername = "eren";
        final String demoPassword = "1203";

        // Kullanıcı adı ve şifrenin doğruluğunu kontrol ediyoruz.
        if (demoUsername.equals(credentials.getUsername()) && demoPassword.equals(credentials.getPassword())) {
            // Kimlik doğrulama başarılı, örnek bir token döndür.
            return new ResponseEntity<>("fake-jwt-token", HttpStatus.OK);
        } else {
            // Kimlik doğrulama başarısız, hata mesajı döndür.
            return new ResponseEntity<>("Authentication failed", HttpStatus.UNAUTHORIZED);
        }
    }


}
