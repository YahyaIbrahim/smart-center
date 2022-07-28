package com.wellware.smart.controllers;

import com.wellware.smart.DTO.MaterialDTO;
import com.wellware.smart.DTO.SubDTO;
import com.wellware.smart.entities.Student;
import com.wellware.smart.entities.Subject;
import com.wellware.smart.services.SubjectService;
import com.wellware.smart.success.Success;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@Api(value = "Subject APIs", tags = {"Subject Management"},
        description = "Subject operations")
@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class SubjectController {

    @Autowired
    private SubjectService subjectService;


    @GetMapping(path = "/subject/{id}/get-students")
    public Success getAllStudentInGroup(@PathVariable long id){
        List<Student> studentGroups = subjectService.getAllStudent(id);
        return new Success(200,true,studentGroups,"");
    }

    @GetMapping(path = "/subject/get-all")
    public Success getAll(){
        return new Success(200,true,subjectService.getAll(),"");
    }

    @PostMapping(path = "/subject/add")
    public Success save(@RequestBody SubDTO subDTO){
        try {
            Subject subject = subjectService.save(subDTO);
            return new Success(200,true,subject,"");
        }catch (Exception e)
        {
            return new Success(200,true,null,e.getMessage());
        }

    }
}
