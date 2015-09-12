package com.op.service.domain.repository;

import com.op.service.domain.entity.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomainRepository extends JpaRepository<Domain, Long> {
    Domain findById(Long id);
}
