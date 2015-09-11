package com.panasonic.gateway.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.panasonic.gateway.client.DomainClient;
import com.panasonic.gateway.client.PortalClient;
import com.panasonic.gateway.to.Domain;
import com.panasonic.gateway.to.Portal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.Environment;

import java.util.Arrays;
import java.util.Collection;

@Component
public class DomainWithPortalsServiceWithFallbacks {
	@Autowired
	private Environment environment;

	@Autowired
	private DomainClient domainClient;

	@Autowired
	private PortalClient portalClient;

    public Collection<Portal> getPortalsFallback(Long domainId) {
        System.out.println("getPortalsFallback");
        return Arrays.asList();
    }

    @HystrixCommand(fallbackMethod = "getPortalsFallback")
    public Collection<Portal> getPortals(Long domainId) {
        return this.portalClient.getPortals(domainId);
    }

    public Domain getDomainFallback(Long domainId) {
        System.out.println("getDomainFallback");
        return new Domain();
    }

    @HystrixCommand(fallbackMethod = "getDomainFallback")
    public Domain getDomain(Long domainId) {
        return this.domainClient.getDomain(domainId);
    }
}
