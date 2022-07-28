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
@Table(name = "school_type")
@Proxy(lazy = false)
public class SchoolType extends AuditModel {

    @Column(name = "type")
    private String type;

    @JsonIgnore
    @OneToMany(mappedBy = "schoolType")
    private List<Student> student;

    @JsonIgnore
    @OneToMany(mappedBy = "schoolType")
    private List<Group> group;

    @JsonIgnore
    @OneToMany(mappedBy = "schoolType")
    private List<Subject> subject;


}
