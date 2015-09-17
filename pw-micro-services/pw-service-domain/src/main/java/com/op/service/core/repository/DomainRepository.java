package com.op.service.core.repository;

import com.op.service.core.model.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomainRepository extends JpaRepository<Domain, Long> {
    Domain findById(Long id);
}
