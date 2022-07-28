package com.wellware.smart.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "grade")
@Proxy(lazy = false)
public class Grade extends AuditModel {

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "grade")
    private List<Student> student;

    @JsonIgnore
    @OneToMany(mappedBy = "grade")
    private List<Group> group;

    @JsonIgnore
    @OneToMany(mappedBy = "grade")
    private List<Subject> subject;


}
