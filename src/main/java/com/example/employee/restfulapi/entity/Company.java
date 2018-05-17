package com.example.employee.restfulapi.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Company")
public class Company {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String companyName;
    private Integer employeesNumber;

    @OneToMany(mappedBy="company",cascade=CascadeType.REMOVE,fetch=FetchType.LAZY)
    private Set<Employee> employees = new HashSet<>();

    public Company(){}

    public Company(CompanyBaseInfo companyBaseInfo){
        this(companyBaseInfo.getCompanyName(),companyBaseInfo.getEmployeesNumber());
    }

    public Company(String companyName, Integer employeesNumber){
        this.companyName = companyName;
        this.employeesNumber = employeesNumber;
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

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}

