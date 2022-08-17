package com.suleysoft.employeems.endpoint.web;

import com.suleysoft.employeems.endpoint.api.EmployeeApi;
import com.suleysoft.employeems.model.Employee;
import com.suleysoft.employeems.serviceImpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController implements EmployeeApi {
    @Autowired
    EmployeeServiceImpl employeeService;
    @Override
    public ResponseEntity<Employee> saveEmployee(Employee employee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Employee> saveEmployee(Employee employee, long id) {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id),HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<List<Employee>> findAllEmployees() {
        List<Employee> employee=employeeService.fetchAllEmployees();
        return new  ResponseEntity<List<Employee>>(employee,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Employee> fetchEmployeeById(long id) {
        Employee employee=employeeService.fetchEmployeeById(id);
        return  new ResponseEntity<Employee>(employee,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteEmployeeById(long id) {
        employeeService.fetchEmployeeById(id);
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>("Delete Successifully",HttpStatus.OK);
    }

}
