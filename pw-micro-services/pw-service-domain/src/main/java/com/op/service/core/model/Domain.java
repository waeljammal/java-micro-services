package com.op.service.core.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "domains")
@Getter
@Setter
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    @NonNull
    private String name;

    @Column(name = "airline_id")
    private String airlineId;

    @Column(name = "max_content_size")
    @Type(type = "com.op.service.core.util.hibernate.SizeType")
    private Size maxContentSize;

    @Column(name = "logo")
    private String logo;

	public Domain(String name) {
        this.name = name;
    }

    public Domain() { }
}