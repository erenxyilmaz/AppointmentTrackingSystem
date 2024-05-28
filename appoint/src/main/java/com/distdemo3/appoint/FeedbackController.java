package com.distdemo3.appoint;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(path="/api/appointments")
public class FeedbackController {

    @PostMapping(path="/feed")
    public ResponseEntity<?> feedbacks(@RequestBody FeedbackRequest feedbackRequest) {
        String durum = "aktif";
        if(durum.equals(feedbackRequest.getDurums())){
            if (!feedbackRequest.getQone().isEmpty() &&
                    !feedbackRequest.getQtwo().isEmpty() &&
                    !feedbackRequest.getQthree().isEmpty() &&
                    !feedbackRequest.getQfour().isEmpty() &&
                    !feedbackRequest.getQfive().isEmpty()) {
                return ResponseEntity.ok("Soruları Cevapladığınız İçin Teşekkür Ederiz.");
            } else {
                return ResponseEntity.badRequest().body("Soruları Lütfen Eksiksiz Doldurunuz.");
            }
        }
        return ResponseEntity.badRequest().body("Randevu durum iletim hatası");
    }
}