package com.wellware.smart.services;

import com.wellware.smart.DTO.MaterialDTO;
import com.wellware.smart.DTO.SubDTO;
import com.wellware.smart.entities.*;
import com.wellware.smart.reposetories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    SubjectRepo subjectRepo;

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    TypeRepo typeRepo;

    @Autowired
    GradeRepo gradeRepo;

    @Autowired
    BranchRepo branchRepo;


    public List<Student> getAllStudent(long id){
        Subject subject = subjectRepo.findAllById(id);
        return studentRepo.findAllBySubjectList(subject);

    }

    public Subject addStudentToSubject(long subjectId, long studentId){
        Subject subject = subjectRepo.findAllById(subjectId);

        Student student = studentRepo.findAllById(studentId);

        StudentSubject studentSubject = new StudentSubject();
        studentSubject.setStudent(student);
        studentSubject.setSubject(subject);

        return subjectRepo.save(subject);

    }

    public List<Subject> getAllSubjectsByBranch(Long id){
        Branch branch = branchRepo.findAllById(id);
        return subjectRepo.findAllByBranch(branch);

    }

    public List<Subject> getAllSubjectsBySchoolType(Long id){
        SchoolType type = typeRepo.findAllById(id);
        return subjectRepo.findAllBySchoolType(type);

    }

    public List<Subject> getAllSubjectsByGrade(Long id){
        Grade grade = gradeRepo.findAllById(id);
        return subjectRepo.findAllByGrade(grade);

    }

    public List<Subject> getAll(){
        return subjectRepo.findAll();

    }

    public Subject save(SubDTO subDTO){
        Grade grade = gradeRepo.findAllById(subDTO.getGrade());
        SchoolType type = typeRepo.findAllById(subDTO.getSchoolType());
        Branch branch = branchRepo.findAllById(subDTO.getBranch());

        Subject subject = new Subject();
        subject.setName(subDTO.getName());
        subject.setPrice(subDTO.getPrice());
        subject.setBranch(branch);
        subject.setGrade(grade);
        subject.setSchoolType(type);
        return subjectRepo.save(subject);

    }



}
