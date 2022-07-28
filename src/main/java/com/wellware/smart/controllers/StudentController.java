package com.wellware.smart.controllers;

import com.wellware.smart.DTO.StudentDTO;
import com.wellware.smart.entities.Student;
import com.wellware.smart.services.StudentService;
import com.wellware.smart.success.Success;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@Api(value = "Student APIs", tags = {"Student Management"},
        description = "Student operations")
@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class StudentController {
    @Autowired
    private StudentService studentService;


    @PostMapping(path = "/student/add-student")
    public Success register(@RequestBody StudentDTO studentDTO) {
        try {
             studentService.save(studentDTO);
            return new Success(200,true,null,"");
        }catch (Exception e)
        {
            return new Success(400,false,null,e.getMessage());
        }

    }

    @GetMapping(path = "/student/get-all-students")
    public Success getAll(){
        List<Student> students = studentService.getAll();
        return new Success(200,true,students,"");
    }

    @PostMapping(path = "/student/{id}/update-student")
    public Success update(@RequestBody StudentDTO studentDTO, @PathVariable long id){
        try {
            Student updateStudent = studentService.update(id,studentDTO);
            return new Success(200,true,updateStudent,"");
        }catch (Exception e){
            return new Success(400,false,null,e.getMessage());
        }

    }

    @GetMapping(path = "/student/{name}/find")
    public Success findByName(@PathVariable String name){
        List<Student> students = studentService.getByName(name);
        if(students.size() != 0)
            return new Success(200,true,students,"");
        return new Success(400,false,null,"There's no student with this name");
    }




}
