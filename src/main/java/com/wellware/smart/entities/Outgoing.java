package com.wellware.smart.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "outgoing")
@Proxy(lazy = false)
@Transactional
public class Outgoing extends AuditModel {

    @NotNull
    @Column(name = "text")
    private String text;


    @NotNull
    @Column(name = "date")
    private String date;


    @NotNull
    @Column(name = "amount")
    private String amount;


}
