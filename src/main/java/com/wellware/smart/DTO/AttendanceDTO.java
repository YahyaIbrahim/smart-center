package com.wellware.smart.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class AttendanceDTO {

    private Date date;

    private boolean attendance;

    private String grade;

    private long studentId;

    private long subjectId;

    private long groupId;
}
