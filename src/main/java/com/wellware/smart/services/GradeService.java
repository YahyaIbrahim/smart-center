package com.wellware.smart.services;

import com.wellware.smart.entities.Grade;
import com.wellware.smart.reposetories.GradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    @Autowired
    private GradeRepo gradeRepo;


    public List<Grade> getAll(){
        return gradeRepo.findAll();
    }
}
