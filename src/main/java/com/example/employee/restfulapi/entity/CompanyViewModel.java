package com.example.employee.restfulapi.entity;

import java.util.Set;
import java.util.stream.Collectors;


public class CompanyViewModel {
    private long id;
    private String companyName;
    private Integer employeesNumber;
    private Set<EmployeeBaseInfo> employees;

    public CompanyViewModel(Company company){
        this.id = company.getId();
        this.companyName = company.getCompanyName();
        this.employeesNumber = company.getEmployeesNumber();
        this.employees = company.getEmployees().stream().map(m -> new EmployeeBaseInfo(m)).collect(Collectors.toSet());
    }

    public long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Integer getEmployeesNumber() {
        return employeesNumber;
    }

    public Set<EmployeeBaseInfo> getEmployees() {
        return employees;
    }
}
