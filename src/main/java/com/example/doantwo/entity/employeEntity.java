package com.example.doantwo.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "employee")
@Data
@Getter
@Setter
public class EmployeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private int EmployeeCode;
    private String Name;
    private String Position;
    private String Phone;
    private Date Birthday;
    private String CardCode;
}
