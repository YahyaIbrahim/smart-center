package com.wellware.smart.reposetories;

import com.wellware.smart.entities.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends CrudRepository<Admin,Long> {

    Admin findByIdAndPassword(long id,String password);
}
