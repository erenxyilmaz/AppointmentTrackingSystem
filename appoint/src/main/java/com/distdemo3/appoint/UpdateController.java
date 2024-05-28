package com.distdemo3.appoint;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(path="/api/appointments")
public class UpdateController {

    @PostMapping(path = "/update")
    public String update(@RequestBody UpdateRequest updateRequest) {
        String durumMesaji;
        if (updateRequest.getNo().length() == 11 && updateRequest.getNo().matches("\\d+")) {
            if (!updateRequest.getName().isBlank() && !updateRequest.getSurname().isBlank() &&
                    updateRequest.getName().matches("^[a-zA-Z]+$") && updateRequest.getSurname().matches("^[a-zA-Z]+$")) {
                // Burada güncelleme işlemlerinizi yapın
                durumMesaji = "Registration successful.";
            } else {
                durumMesaji = "Name and surname fields must not be empty and must contain only letters";
            }
        } else {
            durumMesaji = "The identification number must be 11 digits long and consist only of numbers.";
        }
        return durumMesaji;
    }
}

