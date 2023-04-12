package com.example.doantwo.modal;

import java.sql.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
public class EmployeeDto {

    private int Id;
    private int EmployeeCode;
    private String Name;
    private String Position;
    private String Phone;
    private Date Birthday;
    private String CardCode;
}
