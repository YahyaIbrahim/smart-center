package com.wellware.smart.controllers;

import com.wellware.smart.DTO.Login;
import com.wellware.smart.entities.Admin;
import com.wellware.smart.entities.Employee;
import com.wellware.smart.services.AdminService;
import com.wellware.smart.success.Success;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "Login APIs", tags = {"Login Management"},
        description = "Login operations")
@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class LoginController {


    @Autowired
    private AdminService adminService;

    @PostMapping(path = "/admin/login")
    public Success loginAdmin(@RequestBody Login login){
        Admin admin = adminService.loginAdmin(login);
        if(admin != null)
            return new Success(200,true,admin,"");
        return new Success(400,false,null,"the id or the password is wrong");


    }

    @PostMapping(path = "/user/login")
    public Success loginUser(@RequestBody Login login){
        Employee employee = adminService.loginEmployee(login);
        if(employee != null)
            return new Success(200,true,employee,"");
        return new Success(400,false,null,"the id or the password is wrong");


        }


}
