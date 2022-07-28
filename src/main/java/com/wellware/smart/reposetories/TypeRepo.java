package com.wellware.smart.reposetories;

import com.wellware.smart.entities.SchoolType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepo extends CrudRepository<SchoolType,Long> {

    List<SchoolType> findAll();

    SchoolType findAllById(long id);
}
