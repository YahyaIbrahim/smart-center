package com.wellware.smart.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wellware.smart.Serializable.BranchJson;
import com.wellware.smart.Serializable.StudentJson;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "branch")
@Proxy(lazy = false)
public class Branch extends AuditModel {

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "branch")
    private List<Student> student;

    @JsonIgnore
    @OneToMany(mappedBy="branch")
    private List<Group> group;

    @JsonIgnore
    @OneToMany(mappedBy = "branch")
    private List<Subject> subject;

}
