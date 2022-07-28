package com.wellware.smart.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wellware.smart.Serializable.GroupJson;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "`group`")
@Transactional
@Proxy(lazy = false)
@JsonSerialize(using = GroupJson.class)
public class Group extends AuditModel implements Serializable {

    @NotNull
    @Column(name = "group_name")
    private String groupName;

    @NotNull
    @ManyToOne(targetEntity = SchoolType.class, optional = false,
            fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "school_type", nullable = false)
    private SchoolType schoolType;

    @NotNull
    @ManyToOne(targetEntity = Grade.class, optional = false,
            fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "grade", nullable = false)
    private Grade grade;



    @ManyToOne(targetEntity = Subject.class, optional = false, fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE)
    @JoinColumn(name = "subject", nullable = false)
    private Subject subject;



    @ManyToOne(targetEntity = Branch.class, optional = false,
            fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "branch_id", nullable=false)
    private Branch branch;

}
