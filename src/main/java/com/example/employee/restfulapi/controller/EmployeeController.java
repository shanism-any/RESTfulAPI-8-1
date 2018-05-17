package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.*;
import com.example.employee.restfulapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {
    //在此处完成Company API
    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(value="/employees", method= RequestMethod.GET)
    public List<EmployeeViewModel> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(m -> new EmployeeViewModel(m)).collect(Collectors.toList());
    }

    @RequestMapping(value="/employees/{id}", method= RequestMethod.GET)
    public EmployeeViewModel getEmployee(@PathVariable long id) {
        Employee employee = employeeRepository.findOne(id);
        return new EmployeeViewModel(employee);
    }

    @RequestMapping(value="/employees/page/{page}/pageSize/{pageSize}", method= RequestMethod.GET)
    public List<EmployeeViewModel> getEmployees(@PathVariable int page, @PathVariable int pageSize) {
        Page<Employee> employees = employeeRepository.findAll(new PageRequest(page, pageSize));
        return employees.map(m -> new EmployeeViewModel(m)).getContent();
    }

    @RequestMapping(value="/employees/male", method= RequestMethod.GET)
    public List<EmployeeViewModel> getEmployeesOfMale() {
        List<Employee> employees = employeeRepository.findByGender("male");
        return employees.stream().map(m -> new EmployeeViewModel(m)).collect(Collectors.toList());
    }

    @RequestMapping(value="/employees", method= RequestMethod.POST, consumes = "application/json")
    public EmployeeViewModel createEmployee(@RequestBody EmployeeBaseInfo employeeBaseInfo) {
        Employee employee = new Employee(employeeBaseInfo);
        Employee savedEmployee = employeeRepository.save(employee);
        return new EmployeeViewModel(savedEmployee);
    }

    @RequestMapping(value="/employees/{employeeId}", method= RequestMethod.PUT, consumes = "application/json")
    public EmployeeViewModel updateEmployee(@PathVariable long employeeId, @RequestBody EmployeeBaseInfo employeeBaseInfo) {
        Employee employee = employeeRepository.findOne(employeeId);
        employee.setName(employeeBaseInfo.getName());
        employee.setAge(employeeBaseInfo.getAge());
        employee.setGender(employeeBaseInfo.getGender());
        employee.setSalary(employeeBaseInfo.getSalary());
        employee.setCompanyId(employeeBaseInfo.getCompanyId());
        Employee savedEmployee = employeeRepository.save(employee);
        return new EmployeeViewModel(savedEmployee);
    }

    @RequestMapping(value="/employees/{id}", method= RequestMethod.DELETE)
    public  String  deleteEmployee(@PathVariable long id) {
        employeeRepository.delete(id);
        return "success";
    }
}
