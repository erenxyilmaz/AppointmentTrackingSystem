package com.distdemo3.appoint;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(path="/api/appointments")
public class RegistrationController {


    @PostMapping(path = "/regis")
    public ResponseEntity<String> registerUser(@RequestBody RegistrationRequest registrationRequest) {
        if (registrationRequest.getNo().length() == 11 && registrationRequest.getNo().matches("\\d+")) {
            if (!registrationRequest.getName().isBlank() && !registrationRequest.getSurname().isBlank() &&
                    registrationRequest.getName().matches("^[a-zA-Z]+$") && registrationRequest.getSurname().matches("^[a-zA-Z]+$")) {
                String responseMessage = String.format(
                        "Kayıt Başarılı \n Merhaba Sayın %s %s Kimlik No %s Kullanıcı Türü %s Kurum adı: %s kullanıcı adınız: %s Şifreniz: %s",
                        registrationRequest.getName(), registrationRequest.getSurname(), registrationRequest.getNo(), registrationRequest.getType(),
                        registrationRequest.getKurum(), registrationRequest.getKullaniciName(), registrationRequest.getKulSifre());
                return ResponseEntity.ok(responseMessage);
            } else {
                return ResponseEntity.badRequest().body("İsim ve soyisim alanları boş olmamalı ve sadece harf içermelidir");
            }
        } else {
            return ResponseEntity.badRequest().body("Kimlik numarası 11 haneli olmalı ve sadece sayılardan oluşmalıdır");
        }
    }
}