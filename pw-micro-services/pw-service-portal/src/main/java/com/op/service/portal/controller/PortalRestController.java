package com.op.service.portal.controller;

import com.op.service.core.exception.OpenPlatformException;
import com.op.service.portal.model.Portal;
import com.op.service.portal.model.to.OpenPortalStruct;
import com.op.service.portal.repository.PortalRepository;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.security.oauth2.resource.EnableOAuth2Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.Principal;
import java.util.Collection;

@RestController
@RequestMapping("/{domainId}")
@EnableOAuth2Resource
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

    @RequestMapping(value = "/{portalId}/open", method = RequestMethod.GET)
    public OpenPortalStruct open(
        @PathVariable("portalId") final Long portalId,
        final Principal principal,
        @RequestParam("override") final boolean override,
        @RequestParam("branch") final String branch
    ) throws IOException {
        try {
            return null;
        } catch (HibernateException | IllegalArgumentException ex) {
            throw new OpenPlatformException(ex);
        }
    }
}