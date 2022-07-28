package com.wellware.smart.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wellware.smart.Serializable.SubjectJson;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "subject")
@JsonSerialize(using = SubjectJson.class)
@Transactional
@Proxy(lazy = false)

public class Subject extends AuditModel implements Serializable {

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @ManyToOne(targetEntity = Grade.class, optional = false,
            fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "grade", nullable = false)
    private Grade grade;

    @NotNull
    @Column(name = "price")
    private String price;


    @NotNull
    @ManyToOne(targetEntity = SchoolType.class, optional = false,
            fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "school_type", nullable = false)
    private SchoolType schoolType;



    @OneToMany(fetch = FetchType.EAGER,mappedBy= "subject",cascade = CascadeType.MERGE)
    private List<Group> groups;



    @ManyToOne(targetEntity = Branch.class, optional = false,
            fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "branch", nullable=false)
    private Branch branch;


}
