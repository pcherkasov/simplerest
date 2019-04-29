package com.godel.java.task.controller;

import com.godel.java.task.dto.Employee;
import com.godel.java.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class EmployeeController.
 * create 15.04.2019.
 *
 * @author Pavel Cherkasov
 */

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getUsers() {
        return employeeService.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") int id) {
        return employeeService.findById(id);
    }

    @PostMapping("/employee")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        employeeService.sddNewEmployee(employee);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }
}