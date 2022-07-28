package com.wellware.smart.controllers;

import com.wellware.smart.DTO.EmployeeDTO;
import com.wellware.smart.DTO.OutgoingDTO;
import com.wellware.smart.entities.Employee;
import com.wellware.smart.entities.Outgoing;
import com.wellware.smart.services.AdminService;
import com.wellware.smart.success.Success;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Admin APIs", tags = {"Admin Management"},
        description = "Admin operations")
@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class AdminController {

    @Autowired
    private AdminService adminService;


    @PostMapping(path = "/admin/add-new-user")
    public Success addNewUser(@RequestBody EmployeeDTO employeeDTO){
        try {
            adminService.save(employeeDTO);
            return new Success(200,true,null,"");
        }catch (Exception e) {
            return new Success(400,false,null,e.getMessage());
        }
    }

    @PostMapping(path = "/admin/{id}/edit-user")
    public Success updateUser(@RequestBody EmployeeDTO employeeDTO, @PathVariable long id){
        try {
            Employee employee =  adminService.update(employeeDTO,id);
            return new Success(200,true,employee,"");
        }catch (Exception e) {
            return new Success(400,false,null,e.getMessage());
        }
    }

    @GetMapping(path = "/admin/get-all-users")
    public Success getAll(){
        List<Employee> employees = adminService.getAll();
        return new Success(200,true,employees,"");
    }

    @DeleteMapping(path = "/admin/{id}/delete-user")
    public void deleteUser(@PathVariable long id){
        adminService.delete(id);
    }


    @PostMapping(path = "/admin/add-outgoing")
    public Success addNewGroup(@RequestBody OutgoingDTO OutgoingDTO){
        try {
            Outgoing outgoing =  adminService.saveOut(OutgoingDTO);
            return new Success(200,true,outgoing,"");
        }catch (Exception e) {
            return new Success(400,false,null,e.getMessage());
        }
    }

    @GetMapping(path = "/admin/get-all-outgoing")
    public Success getAllOutGoing(){
        List<Outgoing> outgoings = adminService.getAllOut();
        return new Success(200,true,outgoings,"");
    }

}
