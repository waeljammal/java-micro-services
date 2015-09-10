package com.panasonic.gateway.client;

import com.panasonic.gateway.to.Portal;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@FeignClient("portal-service")
public interface PortalClient {
	@RequestMapping(method = RequestMethod.GET, value = "/{domainId}/portal")
    public Collection<Portal> getPortals(@PathVariable("domainId") Long domainId);

    @RequestMapping(method = RequestMethod.GET, value = "/{domainId}/portal/{portalId}")
    public Portal getPortal(@PathVariable("domainId") Long domainId, @PathVariable("portalId") Long portalId);
}
