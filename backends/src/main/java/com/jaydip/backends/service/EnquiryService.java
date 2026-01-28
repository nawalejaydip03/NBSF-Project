package com.jaydip.backends.service;

import com.jaydip.backends.model.Enquiry;
import com.jaydip.backends.repository.EnquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EnquiryService {

    @Autowired
    private EnquiryRepository enquiryRepository;

    @Transactional
    public Enquiry saveEnquiry(Enquiry enquiry) {
        enquiry.setStatus(Enquiry.EnquiryStatus.NEW);
        enquiry.setCreatedAt(LocalDateTime.now());
        return enquiryRepository.save(enquiry);
    }

    public List<Enquiry> getAllEnquiries() {
        return enquiryRepository.findAll();
    }

    public Optional<Enquiry> getEnquiryById(Long id) {
        return enquiryRepository.findById(id);
    }

    public List<Enquiry> getEnquiriesByStatus(String status) {
        try {
            Enquiry.EnquiryStatus enumStatus = Enquiry.EnquiryStatus.valueOf(status.toUpperCase());
            return enquiryRepository.findByStatus(enumStatus);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid status: " + status);
        }
    }

    public List<Enquiry> searchEnquiries(String keyword) {
        return enquiryRepository.searchByKeyword(keyword);
    }

    @Transactional
    public Enquiry updateStatus(Long id, String status) {
        Enquiry enquiry = enquiryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enquiry not found"));

        try {
            Enquiry.EnquiryStatus newStatus = Enquiry.EnquiryStatus.valueOf(status.toUpperCase());
            enquiry.setStatus(newStatus);

            if (newStatus == Enquiry.EnquiryStatus.CONTACTED && enquiry.getContactedAt() == null) {
                enquiry.setContactedAt(LocalDateTime.now());
            }

            return enquiryRepository.save(enquiry);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid status: " + status);
        }
    }

    public Map<String, Object> getStatistics() {
        LocalDateTime today = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);

        long total = enquiryRepository.count();
        long todayCount = enquiryRepository.countByCreatedAtAfter(today);
        long newCount = enquiryRepository.countByStatus(Enquiry.EnquiryStatus.NEW);
        long contactedCount = enquiryRepository.countByStatus(Enquiry.EnquiryStatus.CONTACTED);
        long resolvedCount = enquiryRepository.countByStatus(Enquiry.EnquiryStatus.RESOLVED);

        return Map.of(
                "total", total,
                "today", todayCount,
                "new", newCount,
                "contacted", contactedCount,
                "resolved", resolvedCount);
    }
}