package com.suleysoft.employeems.serviceImpl;

import com.suleysoft.employeems.exception.ResourceNotFoundException;
import com.suleysoft.employeems.model.Employee;
import com.suleysoft.employeems.repository.EmployeeRepository;
import com.suleysoft.employeems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee fetchEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow(()->new  ResourceNotFoundException("Employee","Id",id));
    }

    @Override
    public void deleteEmployeeById(long id) {
      employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee,long id) {
        Employee existingEmployee=employeeRepository.findById(id).orElseThrow(()->new  ResourceNotFoundException("Employee","Id",id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }
}
