package com.distdemo3.appoint;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/appointments/service-provider")
public class ServiceProviderController {

    // This will act as our in-memory store for demonstration purposes
    private final ConcurrentHashMap<String, ServiceProvider> registeredProviders = new ConcurrentHashMap<>();



    @PostMapping("/register")
    public ResponseEntity<String> registerServiceProvider(@RequestBody ServiceProvider serviceProvider) {
        // Check if the service provider is already registered
        if (registeredProviders.containsKey(serviceProvider.getId())) {
            return ResponseEntity.badRequest().body("Service provider is already registered.");
        }

        // Register the new service provider
        registeredProviders.put(serviceProvider.getId(), serviceProvider);
        return ResponseEntity.ok("Service provider registered successfully.");
    }

    // Additional endpoint to list all service providers
    @GetMapping("/list")
    public ResponseEntity<Object> listServiceProviders() {
        return ResponseEntity.ok(registeredProviders.values());
    }
}