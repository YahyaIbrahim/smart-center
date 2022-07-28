package com.wellware.smart.reposetories;

import com.wellware.smart.entities.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepo extends CrudRepository<Subject,Long> {

    Subject findAllById(Long id);

    List<Subject> findAllByBranch(Branch branch);

    List<Subject> findAllBySchoolType(SchoolType schoolType);

    List<Subject> findAllByGrade(Grade grade);

    List<Subject> findAll();

}
