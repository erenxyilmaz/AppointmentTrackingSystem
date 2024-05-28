package com.distdemo3.appoint;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;


//endpoint 12
@RestController
@RequestMapping(path = "/api/appointments/services")
public class ServiceCategoryController {

    // Statik bir hizmet kategorileri listesi
    private List<String> serviceCategories = Arrays.asList(
            "Health", "Education", "Repair", "Beauty", "Sports", "Consulting"
    );

    // Hizmet kategorilerini listeleyen GET endpoint'i
    @GetMapping("/categories")
    public ResponseEntity<List<String>> getServiceCategories() {
        // Gerçekte bu veriler veritabanından alınır.
        return ResponseEntity.ok(serviceCategories);
    }
}