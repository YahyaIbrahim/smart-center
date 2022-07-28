package com.wellware.smart.services;

import com.wellware.smart.DTO.AttendanceDTO;
import com.wellware.smart.entities.Attendance;
import com.wellware.smart.entities.Group;
import com.wellware.smart.entities.Student;
import com.wellware.smart.entities.Subject;
import com.wellware.smart.reposetories.AttendanceRepo;
import com.wellware.smart.reposetories.GroupRepo;
import com.wellware.smart.reposetories.StudentRepo;
import com.wellware.smart.reposetories.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepo attendanceRepo;
    @Autowired
    GroupRepo groupRepo;

    @Autowired
    StudentRepo studentRepo;
    @Autowired
    SubjectRepo subjectRepo;


    public Attendance save(AttendanceDTO attendanceDTO){
        Attendance attendance = new Attendance();

        Student student = studentRepo.findAllById(attendanceDTO.getStudentId());

        Group group = groupRepo.findAllById(attendanceDTO.getGroupId());

        Subject subject = subjectRepo.findAllById(attendanceDTO.getSubjectId());

        attendance.setAttendance(attendanceDTO.isAttendance());
        attendance.setDate(attendanceDTO.getDate());
        attendance.setGrade(attendanceDTO.getGrade());
        attendance.setStudent(student);
        attendance.setGroup(group);
        attendance.setSubject(subject);

        return attendanceRepo.save(attendance);

    }
}
