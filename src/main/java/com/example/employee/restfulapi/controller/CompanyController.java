package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.*;
import com.example.employee.restfulapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class CompanyController {
    //在此处完成Company API
    @Autowired
    private CompanyRepository companyRepository;

    @RequestMapping(value="/companies", method= RequestMethod.GET)
    public List<CompanyViewModel> getCompanies() {
        List<Company> companies = companyRepository.findAll();
        return companies.stream().map(m -> new CompanyViewModel(m)).collect(Collectors.toList());
    }

    @RequestMapping(value="/companies/{id}", method= RequestMethod.GET)
    public CompanyViewModel getCompany(@PathVariable long id) {
        Company company = companyRepository.findOne(id);
        return new CompanyViewModel(company);
    }

    @RequestMapping(value="/companies/{id}/employees", method= RequestMethod.GET)
    public List<EmployeeViewModel> getEmployees(@PathVariable long id) {
        Set<Employee> employees = companyRepository.findOne(id).getEmployees();
        return employees.stream().map(m -> new EmployeeViewModel(m)).collect(Collectors.toList());
    }

    @RequestMapping(value="/companies/page/{page}/pageSize/{pageSize}", method= RequestMethod.GET)
    public List<CompanyViewModel> getCompanies(@PathVariable int page, @PathVariable int pageSize) {
        Page<Company> companies = companyRepository.findAll(new PageRequest(page, pageSize));
        return companies.map(m -> new CompanyViewModel(m)).getContent();
    }

    @RequestMapping(value="/companies", method= RequestMethod.POST, consumes = "application/json")
    public CompanyViewModel createCompany(@RequestBody CompanyBaseInfo companyBaseInfo) {
        Company company = new Company(companyBaseInfo);
        Company savedCompany = companyRepository.save(company);
        return new CompanyViewModel(savedCompany);
    }

    @RequestMapping(value="/companies/{companyId}", method= RequestMethod.PUT, consumes = "application/json")
    public CompanyViewModel updateCompany(@PathVariable long companyId, @RequestBody CompanyBaseInfo companyBaseInfo) {
        Company company = companyRepository.findOne(companyId);
        company.setCompanyName(companyBaseInfo.getCompanyName());
        company.setEmployeesNumber(companyBaseInfo.getEmployeesNumber());
        Company savedCompany = companyRepository.save(company);
        return new CompanyViewModel(savedCompany);
    }


    @RequestMapping(value="/companies/{id}", method= RequestMethod.DELETE)
    public  String  deleteCompany(@PathVariable long id) {
        companyRepository.delete(id);
        return "success";
    }
}
