package com.example.doantwo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.doantwo.modal.EmployeeDto;
import com.example.doantwo.repository.employeeRepository;
import com.example.doantwo.service.employeeservice;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    @Autowired
    private employeeRepository employeeRepository;
    @Autowired
    private employeeservice employeeservice;
    @GetMapping(path = "/all")
    // @ResponseBody
    // public List<employeEntity> getAll(){
    //     return employeeRepository.findAll();
    // }
    public List<EmployeeDto> getAll(){
        return employeeservice.getAll();
    }
    @PostMapping(path = "/add")
    public EmployeeDto addemEmployeeDto(@RequestBody EmployeeDto employeeDto){
        employeeservice.add(employeeDto);
        return employeeDto;
    }
    @RequestMapping(value = "/custom", method = RequestMethod.POST)
    public String custom() {
        return "custom";
    }
    @DeleteMapping(path="/{id}")
    public void delete(@PathVariable(name="Id") Integer Id){
        employeeservice.delete(Id);
        
    // @GetMapping(path = "")
    // public SomeData getMethodName(@RequestParam String param) {
    //     return new SomeData();
    // }
    }
    
}
