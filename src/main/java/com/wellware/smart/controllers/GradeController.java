package com.wellware.smart.controllers;

import com.wellware.smart.entities.Group;
import com.wellware.smart.entities.Student;
import com.wellware.smart.entities.Subject;
import com.wellware.smart.services.GradeService;
import com.wellware.smart.services.GroupService;
import com.wellware.smart.services.StudentService;
import com.wellware.smart.services.SubjectService;
import com.wellware.smart.success.Success;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Grade APIs", tags = {"Grade Management"},
        description = "Grade operations")
@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private GroupService groupService;

    @GetMapping(path = "/grade/all")
    public Success getAllGrade(){
        return new Success(200,true,gradeService.getAll(),"");
    }

    @GetMapping(path = "/grade/{id}/get-students")
    private Success getStudents(@PathVariable Long id){
        List<Student> students = studentService.getAllByGrade(id);
        if(students.size() != 0)
            return new Success(200,true,students,"");
        return new Success(400,false,null,"there's no students here");

    }

    @GetMapping(path = "/grade/{id}/get-groups")
    private Success getGroups(@PathVariable Long id){
        List<Group> groups = groupService.getAllByGrade(id);
        if(groups.size() != 0)
            return new Success(200,true,groups,"");
        return new Success(400,false,null,"there's no groups here");
    }

    @GetMapping(path = "/grade/{id}/get-subjects")
    private Success getSubjects(@PathVariable Long id){
        List<Subject> subjects = subjectService.getAllSubjectsByGrade(id);
        if(subjects.size() != 0)
            return new Success(200,true,subjects,"");
        return new Success(400,false,null,"there's no groups here");
    }

}
