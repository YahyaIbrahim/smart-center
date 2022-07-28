package com.wellware.smart.DTO;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class EmployeeDTO {

    private String name;

    private String password;

    @NotNull
    @Size( max = 14, message = "(Error: The Phone must be 14 numbers)")
    private String phone;
}
