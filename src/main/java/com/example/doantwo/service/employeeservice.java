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

import com.example.doantwo.entity.employeEntity;
import com.example.doantwo.modal.employeeDto;
import com.example.doantwo.repository.employeeRepository;

public interface employeeservice {
    void add(employeeDto employeeDto);
    void update(employeeDto employeeDto);
    void delete(int Id);
    List<employeeDto> getAll();
    employeeDto getOne(int Id);

}
 @Transactional
 @Service
 class employeeserviceimp implements employeeservice{
    @Autowired
     employeeRepository employeeRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public void add(employeeDto employeeDto) {
        employeEntity employee=modelMapper.map(employeeDto,employeEntity.class);
        employeeRepository.save(employee);
        employeeDto.setId(employee.getId());
    }
     
    @Override
    public void update(employeeDto employeeDto) {
        // TODO Auto-generated method stub
    
          
    }

    @Override
    public void delete(int Id) {
       Optional<employeEntity> employeEntity =employeeRepository.findById(Id);
       
        
    }

    @Override
    public List<employeeDto> getAll() {
        
       List<employeeDto> employeeDtos=new ArrayList<employeeDto>();
       employeeRepository.findAll().forEach((employe)->{
        employeeDtos.add(modelMapper.map(employe,employeeDto.class));
       });
       return employeeDtos;
       
    }

    @Override
    public employeeDto getOne(int Id) {
      employeEntity employe= new employeEntity();
      if(employe!=null){
        return  modelMapper.map(employe,employeeDto.class);
      }
        return null;
    }
    
 }