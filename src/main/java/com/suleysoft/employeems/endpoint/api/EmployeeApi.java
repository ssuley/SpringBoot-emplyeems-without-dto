package com.suleysoft.employeems.endpoint.api;

import com.suleysoft.employeems.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/employee")
public interface EmployeeApi {

    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee);
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee,@PathVariable long id);
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Employee>> findAllEmployees();
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Employee> fetchEmployeeById(@PathVariable long id);
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/text")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable long id);
}
