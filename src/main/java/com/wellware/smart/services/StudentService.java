package com.wellware.smart.services;

import com.wellware.smart.DTO.StudentDTO;
import com.wellware.smart.DTO.StudentSubjectDTO;
import com.wellware.smart.entities.*;
import com.wellware.smart.reposetories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    @Autowired
    TypeRepo typeRepo;

    @Autowired
    GradeRepo gradeRepo;

    @Autowired
    StudentSubjectRepo studentSubjectRepo;

    @Autowired
    SubjectRepo subjectRepo;

    @Autowired
    BranchRepo branchRepo;



    public void save(StudentDTO studentDTO){
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setPhone(studentDTO.getPhone());

        Grade grade = gradeRepo.findAllById(studentDTO.getGrade());
        SchoolType schoolType = typeRepo.findAllById(studentDTO.getSchoolType());
        Branch branch = branchRepo.findAllById((long) studentDTO.getBranch());

        student.setSchoolType(schoolType);
        student.setGrade(grade);
        student.setBranch(branch);
        studentRepo.save(student);
        if(studentDTO.getSubjectList().size() != 0){
            studentDTO.getSubjectList().forEach(subjectDTO -> {
                Subject subject = subjectRepo.findAllById(subjectDTO);
                StudentSubject studentSubject = new StudentSubject();
                studentSubject.setStudent(student);
                studentSubject.setSubject(subject);

                studentSubjectRepo.save(studentSubject);

            });
        }

    }

    public List<Student> getAll(){
        return studentRepo.findAll();
    }


    public Student update(long id,StudentDTO studentDTO){
        Student updatedStudent = studentRepo.findAllById(id);
        if(studentDTO.getName() != null)
            updatedStudent.setName(studentDTO.getName());
        if(studentDTO.getPhone() != null)
            updatedStudent.setPhone(studentDTO.getPhone());
        /*if(String.valueOf(studentDTO.getGrade()) != null)
            updatedStudent.setGrade(studentDTO.getGrade());
        if(String.valueOf(studentDTO.getSchoolType()) != null)
            updatedStudent.setSchoolType(studentDTO.getSchoolType());*/

        return studentRepo.save(updatedStudent);

    }

    public List<Student> getAllByBranch(Long id){
        Branch branch = branchRepo.findAllById(id);
        return studentRepo.findAllByBranch(branch);

    }

    public List<Student> getAllBySchoolType(Long id){
        SchoolType type = typeRepo.findAllById(id);
        return studentRepo.findAllBySchoolType(type);

    }

    public List<Student> getAllByGrade(Long id){
        Grade grade = gradeRepo.findAllById(id);
        return studentRepo.findAllByGrade(grade);

    }

    public List<Student> getByName(String name){
        return studentRepo.findByName(name);

    }
}
