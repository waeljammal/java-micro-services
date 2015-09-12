package com.op.gateway.client;

import com.op.gateway.to.Domain;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@FeignClient("domain-service")
public interface DomainClient {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Collection<Domain> getDomains();

    @RequestMapping(value = "/{domainId}", method = RequestMethod.GET)
    public Domain getDomain(@PathVariable("domainId") Long domainId);
}
