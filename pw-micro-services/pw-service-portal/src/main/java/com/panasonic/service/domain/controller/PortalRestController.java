package com.panasonic.service.domain.controller;

import com.panasonic.service.domain.entity.Portal;
import com.panasonic.service.domain.repository.PortalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/{domainId}")
public class PortalRestController {
	@Autowired
	private PortalRepository portalRepository;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Portal> getPortals(@PathVariable Long domainId) {
		return this.portalRepository.findByDomainOwnerId(domainId);
	}

	@RequestMapping(value = "/{portalId}", method = RequestMethod.GET)
	public Portal getPortal(@PathVariable Long domainId, @PathVariable Long portalId) {
		return this.portalRepository.findByDomainOwnerIdAndId(portalId, domainId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Portal createPortal(@PathVariable Long domainId, @RequestBody Portal portal) {
		Portal portalInstance = new Portal(portal.getName(), domainId);
		return this.portalRepository.save(portalInstance);
	}
}