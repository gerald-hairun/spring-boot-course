package com.example.employee.controller;

import com.example.employee.model.Company;
import com.example.employee.model.Employee;
import com.example.employee.service.CompanyService;
import com.example.employee.service.EmployeeService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/api")
public class SeedController {
    @Autowired
    CompanyService companyService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/seed/{nb}")
    public void launchSeeder(@PathVariable(value = "nb") Long nb){
        Faker faker = new Faker(new Locale("fr"));
        // clean every table
        employeeService.cleanEmployees();
        companyService.cleanCompanies();
        // create {nb} companies
        // create {nb * 20} employees
        for (int i = 0; i < nb; i++) {
            Company cmp = new Company();
            String companyName = faker.company().name();
            cmp.setName(companyName);
            cmp = companyService.createCompany(cmp);
            for (int j = 0; j < 20; j++) {
                Employee emp = new Employee();
                String firstname = faker.name().firstName();
                String lastname = faker.name().lastName();
                emp.setFirstName(firstname);
                emp.setLastName(lastname);
                emp.setEmailId(firstname + "." + lastname + "@"+ companyName.trim().replace(' ', '-')+ ".com");
                emp.setCompany(cmp);
                employeeService.createEmployee(emp);
            }
        }
    }
}
