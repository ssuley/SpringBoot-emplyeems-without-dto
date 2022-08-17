package com.suleysoft.employeems.service;

import com.suleysoft.employeems.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> fetchAllEmployees();
    Employee fetchEmployeeById(long id);
    void deleteEmployeeById(long id);
    Employee updateEmployee(Employee employee,long id);
}
