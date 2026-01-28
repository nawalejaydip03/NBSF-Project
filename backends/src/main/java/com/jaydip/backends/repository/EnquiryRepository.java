package com.jaydip.backends.repository;

import com.jaydip.backends.model.Enquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Long> {
    List<Enquiry> findByStatus(Enquiry.EnquiryStatus status);

    List<Enquiry> findByEnquiryType(Enquiry.EnquiryType enquiryType);

    Long countByStatus(Enquiry.EnquiryStatus status);

    Long countByCreatedAtAfter(LocalDateTime date);

    @Query("SELECT e FROM Enquiry e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(e.email) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(e.phone) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(e.message) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Enquiry> searchByKeyword(String keyword);
}