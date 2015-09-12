package com.op.gateway.controller;

import com.op.gateway.service.DomainWithPortalsService;
import com.op.gateway.service.DomainWithPortalsServiceWithFallbacks;
import com.op.gateway.to.Domain;
import com.op.gateway.to.DomainWithPortals;
import com.op.gateway.to.Portal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import reactor.rx.Stream;

@RestController
public class DomainWithPortalsRestController {

	@Autowired
	private DomainWithPortalsService domainWithPortalsService;

    @Autowired
    private DomainWithPortalsServiceWithFallbacks domainWithPortalsServiceWithFallbacks;

	@RequestMapping("/{domainId}/domain-with-portals")
	public DeferredResult<DomainWithPortals> domainWithPortals(@PathVariable Long domainId) {
		DeferredResult<DomainWithPortals> passportDeferredResult = new DeferredResult<>();
		Stream<Portal> portalsStream = this.domainWithPortalsService.getPortals(domainId);
		Stream<Domain> domainStream = this.domainWithPortalsService.getDomain(domainId);
		this.domainWithPortalsService.getDomainWithPortals(domainStream, portalsStream).consume(passportDeferredResult::setResult);
		return passportDeferredResult;
	}

    @RequestMapping("/{domainId}/domain-with-portals-alternative")
    public DomainWithPortals domainWithPortalsAndFallbacks(@PathVariable Long domainId) {
        return new DomainWithPortals(domainWithPortalsServiceWithFallbacks.getDomain(domainId), domainWithPortalsServiceWithFallbacks.getPortals(domainId));
    }
}
