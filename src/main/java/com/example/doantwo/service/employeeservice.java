package com.example.doantwo.service;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.validation.constraints.Null;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.doantwo.entity.EmployeEntity;
import com.example.doantwo.modal.EmployeeDto;
import com.example.doantwo.repository.employeeRepository;

public interface employeeservice {
    void add(EmployeeDto employeeDto);
    void update(EmployeeDto employeeDto);
    void delete(int Id);
    List<EmployeeDto> getAll();
    EmployeeDto getOne(int Id);

}
 @Transactional
 @Service
 class employeeserviceimp implements employeeservice{
    @Autowired
     employeeRepository employeeRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public void add(EmployeeDto employeeDto) {
        EmployeEntity employee=modelMapper.map(employeeDto,EmployeEntity.class);
        employeeRepository.save(employee);
        employeeDto.setId(employee.getId());
    }
     
    @Override
    public void update(EmployeeDto employeeDto) {
        // TODO Auto-generated method stub
    
          
    }

    @Override
    public void delete(int Id) {
       Optional<EmployeEntity> employeEntity =employeeRepository.findById(Id);
       
       
        
    }

    @Override
    public List<EmployeeDto> getAll() {
        
       List<EmployeeDto> employeeDtos=new ArrayList<EmployeeDto>();
       employeeRepository.findAll().forEach((employe)->{
        employeeDtos.add(modelMapper.map(employe,EmployeeDto.class));
       });
       return employeeDtos;
       
    }

    @Override
    public EmployeeDto getOne(int Id) {
      EmployeEntity employe= new EmployeEntity();
      if(employe!=null){
        return  modelMapper.map(employe,EmployeeDto.class);
      }
        return null;
    }
    
 }