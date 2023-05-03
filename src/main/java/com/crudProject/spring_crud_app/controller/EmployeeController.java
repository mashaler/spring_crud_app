package com.crudProject.spring_crud_app.controller;


import com.crudProject.spring_crud_app.model.Employee;
import com.crudProject.spring_crud_app.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //add new employee
    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    //Add more than 1 employee
    @PostMapping("/addEmployees")
    public List<Employee> addEmployees(@RequestBody List<Employee> employees){
        return employeeService.addAllEmployees(employees);
    }

    //Get employee by id
    @GetMapping("/getEmployeeByID/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeByID(id);
    }

    //Get employee by name
    @GetMapping("/getEmployeeByName/{name}")
    public  Employee getEmployeeByName(@PathVariable String name){
        return employeeService.getEmployeeByName(name);
    }

    //Update employee
    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    //Delete employee
    @DeleteMapping("/deleteEmployeeById/{id}")
    public boolean deleteEmployeeById(@PathVariable int id){
        return employeeService.deleteEmployeeByID(id);
    }

}
