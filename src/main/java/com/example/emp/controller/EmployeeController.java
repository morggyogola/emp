package com.example.emp.controller;

import com.example.emp.dto.EmployeeDTO;
import com.example.emp.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){
        try {
            EmployeeDTO createdEmployee = employeeService.createEmployee(employeeDTO);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(createdEmployee.getEmail()).toUri();
            return ResponseEntity.created(location).body(createdEmployee);

        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"An error occured while processing your request",e);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO updatedEmployee = employeeService.updateEmployee(id,employeeDTO);
        return  ResponseEntity.ok(updatedEmployee);
    }
  @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee( id);
        return  ResponseEntity.noContent().build();
  }
  @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id){
        EmployeeDTO employeeDTO1= employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeDTO1);
  }
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
}
