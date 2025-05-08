package com.eucl.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.eucl.model.Meter;

public interface MeterRepository extends JpaRepository<Meter, Long> {
    Optional<Meter> findByMeterId(String meterId);
    List<Meter> findByOwnerId(Long ownerId);
} 
