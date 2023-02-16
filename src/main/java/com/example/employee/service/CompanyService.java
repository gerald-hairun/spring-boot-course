package com.example.employee.service;

import com.example.employee.model.Company;
import com.example.employee.model.Employee;
import com.example.employee.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public Company createCompany(Company comp) {
        return companyRepository.save(comp);
    }

    public List<Company> createManyCompanies(List<Company> comps) {
        return companyRepository.saveAll(comps);
    }

    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompany(Long compId){
        return companyRepository.findById(compId).get();
    }

    public void deleteCompany(Long compId) {
        companyRepository.deleteById(compId);
    }

    public void cleanCompanies(){
        companyRepository.deleteAll();
    }

    public Company updateCompany(Long compId, Company comp){
        Company company = companyRepository.findById(compId).get();
        company.setName(comp.getName());

        return companyRepository.save(company);
    }
}
