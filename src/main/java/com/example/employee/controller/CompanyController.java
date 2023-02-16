package com.example.employee.controller;

import com.example.employee.model.Company;
import com.example.employee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping(value="/companies")
    public List<Company> getCompanies(){
        return companyService.getCompanies();
    }

    @GetMapping(value = "/company/{compId}")
    public Company getCompany(@PathVariable(value = "compId") Long id){
        return companyService.getCompany(id);
    }

    @PostMapping(value = "/company")
    public Company createCompany(@RequestBody Company newComp) {
        return companyService.createCompany(newComp);
    }

    @PutMapping(value = "/company/{compId}")
    public Company updateCompany(@PathVariable(value = "compId") Long id, @RequestBody Company comp){
        return companyService.updateCompany(id, comp);
    }

    @DeleteMapping(value = "/company/{compId}")
    public void deleteCompany(@PathVariable(value = "compId") Long id){
        companyService.deleteCompany(id);
    }
}
