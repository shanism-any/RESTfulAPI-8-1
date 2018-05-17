package com.example.employee.restfulapi.entity;

import java.io.Serializable;


public class CompanyBaseInfo implements Serializable {
    private long id;
    private String companyName;
    private Integer employeesNumber;

    public CompanyBaseInfo(){}

    public CompanyBaseInfo(Company company){
        this.id = company.getId();
        this.companyName = company.getCompanyName();
        this.employeesNumber = company.getEmployeesNumber();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(Integer employeesNumber) {
        this.employeesNumber = employeesNumber;
    }
}
