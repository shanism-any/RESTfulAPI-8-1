package com.example.employee.restfulapi.entity;


public class EmployeeViewModel {

    private long id;
    private String name;
    private Integer age;
    private String gender;
    private Integer salary;
    private long companyId;

    public EmployeeViewModel(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.age = employee.getAge();
        this.gender = employee.getGender();
        this.salary = employee.getSalary();
        this.companyId = employee.getCompanyId();
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Integer getSalary() {
        return salary;
    }

    public long getCompanyId() {
        return companyId;
    }
}


