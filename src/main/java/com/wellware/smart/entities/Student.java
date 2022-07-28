package com.wellware.smart.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wellware.smart.Serializable.StudentJson;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "student")
@Proxy(lazy = false)
@Transactional
@JsonSerialize(using = StudentJson.class)
@Embeddable
public class Student extends AuditModel implements Serializable {

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Size( max = 14, message = "(Error: The Phone must be 14 numbers)")
    @Column(name = "phone")
    private String phone;


    @NotNull
    @ManyToOne(targetEntity = Grade.class, optional = false,
            fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name = "grade", nullable = false)
    private Grade grade;

    @NotNull
    @ManyToOne(targetEntity = SchoolType.class, optional = false,
            fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name = "school_type", nullable = false)
    private SchoolType schoolType;


    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "`student_subject`",
            joinColumns = @JoinColumn(name = "`student_id`"),
            inverseJoinColumns = @JoinColumn(name = "`subject_id`"))
    private Set<Subject> subjectList;

    @ManyToOne(targetEntity = Branch.class, optional = false,
            fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name = "branch", nullable=false)
    private Branch branch;


    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "`student_group`",
            joinColumns = @JoinColumn(name = "`student_id`"),
            inverseJoinColumns = @JoinColumn(name = "`group_id`"))
    private Set<Group> groups;


}
