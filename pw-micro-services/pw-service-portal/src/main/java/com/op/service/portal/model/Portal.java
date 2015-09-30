package com.op.service.portal.model;

import com.op.service.core.model.IPortal;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "portals")
@Getter
@Setter
public class Portal implements IPortal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    @NonNull
    private String name;

    @Column(name = "is_microsite", nullable = false)
    private boolean isMicrosite;

    @Column(name = "domain_owner_id", nullable = false)
    @NonNull
    private Long domainOwnerId;

    @Column(name = "template_url", nullable = true)
    private String url;

    @Column(name = "git_validation", nullable = false)
    private boolean gitValidation;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private PortalStatus status = PortalStatus.active;

    public Portal(String name, Long domainOwnerId) {
        this.domainOwnerId = domainOwnerId;
        this.name = name;
    }

    public Portal() {

    }
}