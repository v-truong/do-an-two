package com.example.doantwo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.doantwo.entity.EmployeEntity;


@Repository
public interface employeeRepository extends JpaRepository <EmployeEntity,Integer>  {
    
}
