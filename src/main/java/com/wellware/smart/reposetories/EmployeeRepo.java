package com.wellware.smart.reposetories;

import com.wellware.smart.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee,Long> {

    Employee findAllById(long id);

    List<Employee> findAll();

    Employee findByIdAndPassword(long id, String password);
}
