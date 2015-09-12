package com.op.gateway.to;

import lombok.Getter;

@Getter
public class Portal {
    private long id;
    private String name;
    private boolean isMicrosite;
    private Long domainOwnerId;
    private String url;
    private boolean gitValidation;
    private PortalStatus status = PortalStatus.active;
}
