package com.wellware.smart.reposetories;

import com.wellware.smart.entities.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends CrudRepository<Student,Long> {

    Student findAllById(Long id);

    List<Student> findAll();

    List<Student> findAllByBranch(Branch branch);

    List<Student> findAllByGroups(Group group);

    List<Student> findAllBySubjectList(Subject subject);

    List<Student> findAllBySchoolType(SchoolType schoolType);

    List<Student> findAllByGrade(Grade grade);

    @Query("select s from Student s where  LOWER(s.name) LIKE LOWER(concat(?1,'%')) ")
    List<Student> findByName(String name);




}
