package com.op.service.core.controller;

import com.op.service.core.model.Domain;
import com.op.service.core.repository.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/")
public class DomainRestController {
    @Autowired
    private DomainRepository portalRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Domain> getDomains() {
        return this.portalRepository.findAll();
    }

    @RequestMapping(value = "/{domainId}", method = RequestMethod.GET)
    public Domain getDomain(@PathVariable Long domainId) {
        return this.portalRepository.findById(domainId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Domain createDomain(@RequestBody Domain domain) {
        Domain portalInstance = new Domain(domain.getName());
        return this.portalRepository.save(portalInstance);
    }
}