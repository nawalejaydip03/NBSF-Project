package com.jaydip.backends.controller;

import com.jaydip.backends.model.Enquiry;
import com.jaydip.backends.service.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/enquiries")
@CrossOrigin(origins = "*")
public class EnquiryController {

    @Autowired
    private EnquiryService enquiryService;

    @GetMapping
    public ResponseEntity<List<Enquiry>> getAllEnquiries() {
        return ResponseEntity.ok(enquiryService.getAllEnquiries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enquiry> getEnquiryById(@PathVariable Long id) {
        return enquiryService.getEnquiryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Enquiry>> getEnquiriesByStatus(@PathVariable String status) {
        return ResponseEntity.ok(enquiryService.getEnquiriesByStatus(status));
    }

    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getStatistics() {
        return ResponseEntity.ok(enquiryService.getStatistics());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Enquiry>> searchEnquiries(@RequestParam String keyword) {
        return ResponseEntity.ok(enquiryService.searchEnquiries(keyword));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable Long id, @RequestBody Map<String, String> request) {
        String status = request.get("status");
        Enquiry updated = enquiryService.updateStatus(id, status);
        return ResponseEntity.ok(Map.of(
                "success", true,
                "message", "Status updated",
                "enquiry", updated));
    }
}