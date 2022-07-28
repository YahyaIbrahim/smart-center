package com.wellware.smart.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student_subject")
@Getter
@Setter
public class StudentSubject extends AuditModel {

    @ManyToOne(targetEntity = Subject.class, optional = false, fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE)
    @JoinColumn(name = "`subject_id`", nullable = false)
    private Subject subject;


    @ManyToOne(targetEntity = Student.class, optional = false, fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE)
    @JoinColumn(name = "`student_id`", nullable = false)
    private Student student;


}
