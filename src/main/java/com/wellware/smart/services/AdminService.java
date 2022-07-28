package com.wellware.smart.services;

import com.wellware.smart.DTO.EmployeeDTO;
import com.wellware.smart.DTO.Login;
import com.wellware.smart.DTO.OutgoingDTO;
import com.wellware.smart.entities.Admin;
import com.wellware.smart.entities.Employee;
import com.wellware.smart.entities.Outgoing;
import com.wellware.smart.reposetories.AdminRepo;
import com.wellware.smart.reposetories.EmployeeRepo;
import com.wellware.smart.reposetories.OutgoingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private OutgoingRepo outgoingRepo;

    @Autowired
    private AdminRepo adminRepo;

    public void save(EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setPassword(employeeDTO.getPassword());
        employee.setPhone(employeeDTO.getPhone());
        employeeRepo.save(employee);
    }

    public void delete(long id){
        Employee employee = employeeRepo.findAllById(id);
        employeeRepo.delete(employee);
    }

    public Employee update(EmployeeDTO employeeDTO,long id){
        Employee updatedEmployee = employeeRepo.findAllById(id);
        if(employeeDTO.getName() != null)
            updatedEmployee.setName(employeeDTO.getName());
        if (employeeDTO.getPhone() != null)
            updatedEmployee.setPhone(employeeDTO.getPhone());
        if (employeeDTO.getPassword() != null)
            updatedEmployee.setPassword(employeeDTO.getPassword());
        return employeeRepo.save(updatedEmployee);
    }

    public List<Employee> getAll(){
        return employeeRepo.findAll();
    }



    public Outgoing saveOut(OutgoingDTO outgoingDTO){

        Outgoing outgoing = new Outgoing();
        outgoing.setAmount(outgoingDTO.getAmount());
        outgoing.setDate(outgoingDTO.getDate());
        outgoing.setText(outgoingDTO.getText());
        return outgoingRepo.save(outgoing);
    }
    public List<Outgoing> getAllOut(){
        return outgoingRepo.findAll();
    }



    public Admin loginAdmin(Login login){
        return adminRepo.findByIdAndPassword(login.getId(), login.getPassword());

    }
    public Employee loginEmployee(Login login){
        return employeeRepo.findByIdAndPassword(login.getId(), login.getPassword());

    }
}
