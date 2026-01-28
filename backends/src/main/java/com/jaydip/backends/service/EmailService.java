package com.jaydip.backends.service;

import com.jaydip.backends.model.Enquiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEnquiryNotification(Enquiry enquiry) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("admin@nbsfgroup.org", "nirmalbharatskillfoundation999@gmail.com");
            message.setSubject("New Enquiry - NBSF Website");

            String text = "New Enquiry Received:\n\n" +
                    "Name: " + enquiry.getName() + "\n" +
                    "Email: " + enquiry.getEmail() + "\n" +
                    "Phone: " + enquiry.getPhone() + "\n" +
                    "Type: " + enquiry.getEnquiryType() + "\n" +
                    "Subject: " + enquiry.getSubject() + "\n" +
                    "Message: " + enquiry.getMessage() + "\n\n" +
                    "Enquiry ID: " + enquiry.getId();

            message.setText(text);
            mailSender.send(message);
            System.out.println("Enquiry notification sent to admin");
        } catch (Exception e) {
            System.err.println("Failed to send enquiry notification: " + e.getMessage());
        }
    }

    public void sendAutoReply(Enquiry enquiry) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(enquiry.getEmail());
            message.setSubject("Thank you for contacting Nirmal Bharat Skill Foundation");

            String text = "Dear " + enquiry.getName() + ",\n\n" +
                    "Thank you for contacting Nirmal Bharat Skill Foundation Group.\n\n" +
                    "We have received your enquiry and our team will contact you within 24 hours.\n\n" +
                    "Your enquiry reference: ENQ-" + enquiry.getId() + "\n\n" +
                    "For immediate assistance, please call: +91 9860085999\n\n" +
                    "Best Regards,\n" +
                    "NBSF Team\n" +
                    "Pune, Maharashtra";

            message.setText(text);
            mailSender.send(message);
            System.out.println("Auto-reply sent to: " + enquiry.getEmail());
        } catch (Exception e) {
            System.err.println("Failed to send auto-reply: " + e.getMessage());
        }
    }

    public void subscribeNewsletter(String email) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Welcome to NBSF Newsletter");

            String text = "Thank you for subscribing to Nirmal Bharat Skill Foundation newsletter!\n\n" +
                    "You will now receive updates about:\n" +
                    "- New training programs\n" +
                    "- Skill development workshops\n" +
                    "- Placement opportunities\n" +
                    "- Success stories\n\n" +
                    "Best Regards,\n" +
                    "NBSF Team";

            message.setText(text);
            mailSender.send(message);
            System.out.println("Newsletter confirmation sent to: " + email);
        } catch (Exception e) {
            System.err.println("Failed to send newsletter confirmation: " + e.getMessage());
        }
    }
}