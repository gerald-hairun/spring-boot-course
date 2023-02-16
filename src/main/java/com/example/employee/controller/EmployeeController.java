package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService empService;

    @GetMapping(value="/employees")
    public List<Employee> readEmployees() {
        return empService.getEmployees();
    }

    @GetMapping(value = "/employees/byCompany/{companyId}")
    public List<Employee> getEmployeesByCompany(@PathVariable("companyId") Long companyId){
        return empService.getEmployeesByCompany(companyId);
    }

    @PostMapping(value="/employees")
    public Employee createEmployee(@RequestBody Employee emp) {
        return empService.createEmployee(emp);
    }

    @PutMapping(value="/employees/{empId}")
    public Employee readEmployees(@PathVariable(value = "empId") Long id, @RequestBody Employee empDetails) {
        return empService.updateEmployee(id, empDetails);
    }

    @DeleteMapping(value="/employees/{empId}")
    public void deleteEmployees(@PathVariable(value = "empId") Long id) {
        empService.deleteEmployee(id);
    }
}
