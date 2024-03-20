package com.example.emp.service;

import com.example.emp.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);

      void deleteEmployee(Long id);
    EmployeeDTO getEmployeeById(Long id);
    List<EmployeeDTO> getAllEmployees();

}
