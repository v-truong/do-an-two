package com.example.doantwo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    @Autowired
    private employeeRepository employeeRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
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
    @GetMapping("/hello")
public void sayHello(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Lấy thông tin về tên người dùng từ tham số truy vấn "name"
    String name = request.getParameter("name");
    
    // Tạo nội dung phản hồi
    String message = "Xin chào, " + (name != null ? name : "khách") + "!";
    
    // Thiết lập mã trạng thái của phản hồi là 200 (OK)
    response.setStatus(HttpServletResponse.SC_OK);
    
    // Thiết lập kiểu nội dung của phản hồi là "text/plain"
    response.setContentType("text/plain");
    
    // Ghi nội dung phản hồi vào luồng đầu ra của phản hồi
    response.getWriter().write(message);
}
@GetMapping("/")
public String home() {
    LOGGER.debug("This is a debug message");
    LOGGER.info("This is an info message");
    LOGGER.warn("This is a warn message");
    LOGGER.error("This is an error message");
    return "home";
}

}
