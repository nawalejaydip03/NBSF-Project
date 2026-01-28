package com.jaydip.backends.repository;

import com.jaydip.backends.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
    List<Partner> findByActiveTrue();

    List<Partner> findByPartnershipType(Partner.PartnershipType type);
}