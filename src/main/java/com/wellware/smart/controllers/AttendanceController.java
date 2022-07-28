package com.wellware.smart.controllers;

import com.wellware.smart.DTO.AttendanceDTO;
import com.wellware.smart.entities.Attendance;
import com.wellware.smart.services.AttendanceService;
import com.wellware.smart.success.Success;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Attendance APIs", tags = {"Attendance Management"},
        description = "Attendance operations")
@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping(path = "/add-attendance")
    public Success addAttendance(@RequestBody AttendanceDTO attendanceDTO){
        try {
            Attendance attendance =  attendanceService.save(attendanceDTO);
            return new Success(200,true,attendance,"");
        }catch (Exception e) {
            return new Success(400,false,null,e.getMessage());
        }
    }
}
