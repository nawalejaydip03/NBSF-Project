package com.jaydip.backends.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jaydip.backends.model.Enquiry;
import com.jaydip.backends.service.EnquiryService;
import com.jaydip.backends.service.EmailService;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactController {

    @Autowired
    private EnquiryService enquiryService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/enquiry")
    public ResponseEntity<?> submitEnquiry(@RequestBody Enquiry enquiry) {
        Enquiry savedEnquiry = enquiryService.saveEnquiry(enquiry);

        // Send email notification to admin
        emailService.sendEnquiryNotification(savedEnquiry);

        // Send auto-reply to user
        emailService.sendAutoReply(savedEnquiry);

        return ResponseEntity.ok(Map.of(
                "success", true,
                "message", "Thank you for your enquiry. We will contact you soon.",
                "enquiryId", savedEnquiry.getId()));
    }

    @PostMapping("/newsletter")
    public ResponseEntity<?> subscribeNewsletter(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        emailService.subscribeNewsletter(email);
        return ResponseEntity.ok(Map.of("success", true, "message", "Subscribed successfully"));
    }
}