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

    @RequestMapping(value="/companies", method = RequestMethod.GET)
    public List<Company> getCompanies(){
        return companyService.getCompanies();
    }

    @RequestMapping(value = "/company/{compId}", method = RequestMethod.GET)
    public Company getCompany(@PathVariable(value = "compId") Long id){
        return companyService.getCompany(id);
    }

    @RequestMapping(value = "/company", method = RequestMethod.POST)
    public Company createCompany(@RequestBody Company newComp) {
        return companyService.createCompany(newComp);
    }

    @RequestMapping(value = "/company/{compId}", method = RequestMethod.PUT)
    public Company updateCompany(@PathVariable(value = "compId") Long id, @RequestBody Company comp){
        return companyService.updateCompany(id, comp);
    }

    @RequestMapping(value = "/company/{compId}", method = RequestMethod.DELETE)
    public void deleteCompany(@PathVariable(value = "compId") Long id){
        companyService.deleteCompany(id);
    }
}
