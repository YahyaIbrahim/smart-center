package com.wellware.smart.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "`student_group`")
@Getter
@Setter
public class StudentGroup extends AuditModel {


    @ManyToOne(targetEntity = Group.class, optional = false, fetch = FetchType.LAZY,
            cascade = { CascadeType.MERGE})
    @JoinColumn(name = "`group_id`", nullable = false)
    private Group group;


    @ManyToOne(targetEntity = Student.class, optional = false, fetch = FetchType.LAZY,
            cascade = { CascadeType.MERGE})
    @JoinColumn(name = "`student_id`", nullable = false)
    private Student student;



}
