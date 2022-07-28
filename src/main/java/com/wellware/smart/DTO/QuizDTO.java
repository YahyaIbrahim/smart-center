package com.wellware.smart.DTO;


import lombok.Data;

import java.util.Date;

@Data
public class QuizDTO {

    private String name;

    private Date date;

    private long groupId;
}
