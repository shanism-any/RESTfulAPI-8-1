package com.example.employee.restfulapi.entity;


public class EmployeeBaseInfo {

    private long id;
    private String name;
    private Integer age;
    private String gender;
    private Integer salary;
    private long companyId;

    public EmployeeBaseInfo(){}

    public EmployeeBaseInfo(Employee employee) {
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

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }
}
