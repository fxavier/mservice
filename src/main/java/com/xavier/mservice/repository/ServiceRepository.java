package com.xavier.mservice.repository;

import com.xavier.mservice.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    Optional<Service> findByServiceName(String name);
    Optional<Service> findByCategoryName(String category);
}
