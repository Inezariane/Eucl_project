package com.eucl.controller;

import com.eucl.model.Meter;
import com.eucl.service.MeterService;
import com.eucl.dto.MeterRegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meters")
public class MeterController {

    @Autowired
    private MeterService meterService;

    // Register a meter for a user (Admin Only)
    @PostMapping("/register")
    public ResponseEntity<String> registerMeter(@RequestBody MeterRegisterRequest request) {
        try {
            String response = meterService.registerMeter(request);
            return ResponseEntity.ok(response);

            } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error registering meter: " + e.getMessage());
        }
    }

    // Get all meters associated with a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Meter>> getByOwnerId(@PathVariable Long userId) {
        try {
            List<Meter> meters = meterService.getByOwnerId(userId);
            return ResponseEntity.ok(meters);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
