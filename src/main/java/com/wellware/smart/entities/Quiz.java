package com.wellware.smart.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "quiz")
@Proxy(lazy = false)
@Transactional
public class Quiz extends AuditModel {

    @NotNull
    @Column(name = "name")
    private String name;


    @NotNull
    @Column(name = "date")
    private Date date;


    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;

}
