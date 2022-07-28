package com.wellware.smart.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "employee")
@Proxy(lazy = false)
@Transactional
public class Employee extends AuditModel {

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "password")
    private String password;


    @NotNull
    @Column(name = "phone")
    private String phone;

}
