package com.panasonic.gateway.controller;

import com.panasonic.gateway.service.DomainWithPortalsService;
import com.panasonic.gateway.to.Domain;
import com.panasonic.gateway.to.DomainWithPortals;
import com.panasonic.gateway.to.Portal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import reactor.rx.Stream;

@RestController
public class DomainWithPortalsRestController {

	@Autowired
	private DomainWithPortalsService passportService;

	@RequestMapping("/{domainId}/domain-with-portals")
	public DeferredResult<DomainWithPortals> passport(@PathVariable Long domainId) {
		DeferredResult<DomainWithPortals> passportDeferredResult = new DeferredResult<>();
		Stream<Portal> portalsStream = this.passportService.getPortals(domainId);
		Stream<Domain> domainStream = this.passportService.getDomain(domainId);
		this.passportService.getDomainWithPortals(domainStream, portalsStream).consume(passportDeferredResult::setResult);
		return passportDeferredResult;
	}
}
