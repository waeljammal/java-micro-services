package com.panasonic.gateway.to;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
public class DomainWithPortals {
    private Domain domain;
    private Collection<Portal> portals;

    public DomainWithPortals() {

    }

    public DomainWithPortals(Domain domain, List<Portal> portals) {
        setDomain(domain);
        setPortals(portals);
    }

    public DomainWithPortals(Domain domain, Collection<Portal> portals) {
        setDomain(domain);
        setPortals(portals);
    }
}
