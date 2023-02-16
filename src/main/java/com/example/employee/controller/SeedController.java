package com.example.employee.controller;

import com.example.employee.model.Company;
import com.example.employee.model.Employee;
import com.example.employee.service.CompanyService;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SeedController {
    @Autowired
    CompanyService companyService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/seed/{nb}")
    public void launchSeeder(@PathVariable(value = "nb") Long nb){
        // clean every table
        employeeService.cleanEmployees();
        companyService.cleanCompanies();
        // create {nb} companies
        // create {nb * 20} employees
        for (int i = 0; i < nb; i++) {
            Company cmp = new Company();
            cmp.setName("Company_"+i);
            cmp = companyService.createCompany(cmp);
            for (int j = 0; j < 20; j++) {
                Employee emp = new Employee();
                String firstname = "First" + j + "-" + i;
                String lastname = "Last" + j + "-" + i;
                emp.setFirstName(firstname);
                emp.setLastName(lastname);
                emp.setEmailId(firstname + "." + lastname + "_@"+"Company_" + i + ".com");
                emp.setCompany(cmp);
                employeeService.createEmployee(emp);
            }
        }
    }
}