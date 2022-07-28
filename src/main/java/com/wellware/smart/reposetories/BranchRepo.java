package com.wellware.smart.reposetories;

import com.wellware.smart.entities.Branch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepo extends CrudRepository<Branch,Long> {

    List<Branch> findAll();

    Branch findAllById(Long id);
}
