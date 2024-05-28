package com.distdemo3.appoint;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


@RestController
    @RequestMapping("/api/appointments")
    public class AppointmentController {

        private final List<AppointDetail> appointmentHistories = new ArrayList<>();

        @PostMapping("/book")
        public ResponseEntity<String> bookAppointment(@RequestBody AppointDetail appointment) {
            appointmentHistories.add(appointment);
            String successMessage = String.format("Appointment successfully booked. Service: %s, Time: %s, Date: %s",
                    appointment.getService(),
                    appointment.getTime(),
                    appointment.getDate());
            return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
        }

        @GetMapping("/history")
        public ResponseEntity<List<AppointDetail>> getAppointmentHistories() {
            return new ResponseEntity<>(appointmentHistories, HttpStatus.OK);
        }

        @PutMapping("/update/{index}")
        public ResponseEntity<String> updateAppointment(@PathVariable int index, @RequestBody AppointDetail updatedAppointment) {
            if (index >= 0 && index < appointmentHistories.size()) {
                AppointDetail existingAppointment = appointmentHistories.set(index, updatedAppointment);
                String updateMessage = String.format("Appointment at index %d updated from Service: %s, Time: %s, Date: %s to Service: %s, Time: %s, Date: %s",
                        index,
                        existingAppointment.getService(),
                        existingAppointment.getTime(),
                        existingAppointment.getDate(),
                        updatedAppointment.getService(),
                        updatedAppointment.getTime(),
                        updatedAppointment.getDate());
                return new ResponseEntity<>(updateMessage, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Appointment index not found.", HttpStatus.NOT_FOUND);
            }
        }

        @DeleteMapping("/delete/{index}")
        public ResponseEntity<String> deleteAppointment(@PathVariable int index) {
            if (index >= 0 && index < appointmentHistories.size()) {
                AppointDetail deletedAppointment = appointmentHistories.remove(index);
                String deleteMessage = String.format("Appointment at index %d with Service: %s, Time: %s, Date: %s has been deleted.",
                        index,
                        deletedAppointment.getService(),
                        deletedAppointment.getTime(),
                        deletedAppointment.getDate());
                return new ResponseEntity<>(deleteMessage, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Appointment index not found.", HttpStatus.NOT_FOUND);
            }
        }

        //endpoint 5
        // Örnek olarak kullanılacak zaman dilimlerini tutan bir liste
        private final List<LocalTime> sampleTimeSlots = Arrays.asList(
                LocalTime.of(9, 0), LocalTime.of(10, 0), LocalTime.of(11, 0),
                LocalTime.of(13, 0), LocalTime.of(14, 0), LocalTime.of(15, 0),
                LocalTime.of(16, 0)
        );


        @GetMapping("/available-slots")
        public String getAvailableSlots(
                @RequestParam String service,
                @RequestParam String date,
                @RequestParam String time) {
            LocalDate queryDate = LocalDate.parse(date);
            LocalTime queryTime = LocalTime.parse(time);

            if (queryDate.isBefore(LocalDate.now())) {
                return "Hayır, geçmiş tarihe randevu alınamaz.";
            } else if (sampleTimeSlots.contains(queryTime)) {
                return "Evet, bu saat müsait.";
            } else {
                return "Hayır, bu saat müsait değil.";
            }
        }

}












