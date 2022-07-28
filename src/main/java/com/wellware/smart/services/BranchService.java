package com.wellware.smart.services;

import com.wellware.smart.entities.Branch;
import com.wellware.smart.reposetories.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {

    @Autowired
    BranchRepo branchRepo;

    public List<Branch> findAll(){
        return branchRepo.findAll();
    }
}
