package com.crudProject.spring_crud_app.services;

import com.crudProject.spring_crud_app.model.Employee;
import com.crudProject.spring_crud_app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> addAllEmployees(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    public Employee getEmployeeByID(int id) {
        return  employeeRepository.findById(id).orElse(null);
    }

    public Employee getEmployeeByName(String name) {
        return  employeeRepository.findByName(name);
    }

    public Employee updateEmployee(Employee employee) {
        Employee  existingEMP = employeeRepository.findById(employee.getId()).orElse(null);

        if(existingEMP == null){
            return employeeRepository.save(employee);
        }else {
            employeeRepository.deleteById(existingEMP.getId());
            employeeRepository.save(employee);
        }
        return employee;
    }

    public boolean deleteEmployeeByID(int id) {
        Employee existingEMP = employeeRepository.getById(id);
        if(existingEMP != null){
            employeeRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
