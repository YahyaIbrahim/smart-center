package com.wellware.smart.DTO;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class StudentDTO {
    @NotNull
    private String name;
    @NotNull
    @Size( max = 14, message = "(Error: The Phone must be 14 numbers)")
    private String phone;
    private int schoolType;
    private int grade;
    private int branch;

    private List<Long> subjectList;
}
