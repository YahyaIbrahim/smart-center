package com.wellware.smart.services;

import com.wellware.smart.entities.SchoolType;
import com.wellware.smart.reposetories.TypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    @Autowired
    private TypeRepo typeRepo;

    public List<SchoolType> getAll(){
        return typeRepo.findAll();
    }
}
