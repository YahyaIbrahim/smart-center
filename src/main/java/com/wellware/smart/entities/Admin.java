package com.wellware.smart.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@Entity
@Table(name = "admin")
@Proxy(lazy = false)
@Transactional
public class Admin extends AuditModel {

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "password")
    private String password;
}
