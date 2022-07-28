package com.wellware.smart.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "attendance")
@Proxy(lazy = false)
public class Attendance extends AuditModel {

    @Column(name = "date")
    private Date date;

    @Column(name = "attendance")
    private boolean attendance;

    @Column(name = "grade")
    private String grade;

    @ManyToOne(targetEntity = Student.class, optional = false, fetch = FetchType.LAZY,
            cascade = { CascadeType.MERGE})
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(targetEntity = Subject.class, optional = false, fetch = FetchType.LAZY,
            cascade = { CascadeType.MERGE})
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @ManyToOne(targetEntity = Group.class, optional = false, fetch = FetchType.LAZY,
            cascade = { CascadeType.MERGE})
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

}
