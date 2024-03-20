package com.example.emp.service.impl;

import com.example.emp.dto.EmployeeDTO;
import com.example.emp.entity.Employee;
import com.example.emp.exception.EmployeeNotFoundException;
import com.example.emp.mapper.EmployeeMapper;
import com.example.emp.repository.EmployeeRepository;
import com.example.emp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeMapper employeeMapper;

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO){
        Employee employee =  employeeMapper.toEntity(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toDto(savedEmployee);
    }
    public  EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()){
             Employee employee= optionalEmployee.get();
             employee.setFirstName(employeeDTO.getFirstName());
             employee.setLastName(employeeDTO.getLastName());
             employee.setEmail(employeeDTO.getEmail());

             employee=employeeRepository.save(employee);
             return employeeMapper.toDto(employee);
        }else {
            throw new EmployeeNotFoundException(id);
        }
    }

    public  void deleteEmployee(Long id){
        employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException(id));
        employeeRepository.deleteById(id);
    }
    public  EmployeeDTO getEmployeeById(Long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException(id));
        return employeeMapper.toDto(employee);
    }

    public List<EmployeeDTO> getAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        return employeeMapper.toDtoList(employees);
    }
}
