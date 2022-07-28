package com.wellware.smart.reposetories;

import com.wellware.smart.entities.Grade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepo extends CrudRepository<Grade,Long> {

    List<Grade> findAll();

    Grade findAllById(long id);
}
