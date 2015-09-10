package com.panasonic.service.domain.repository;

import com.panasonic.service.domain.entity.Portal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortalRepository extends JpaRepository<Portal, Long> {
	List<Portal> findByDomainOwnerId(Long domainOwnerId);
	Portal findByDomainOwnerIdAndId(Long domainOwnerId, Long id);
}
