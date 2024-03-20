package com.example.emp.mapper;

import com.example.emp.dto.EmployeeDTO;
import com.example.emp.entity.Employee;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Component
public interface EmployeeMapper {
    EmployeeDTO toDto(Employee employee);

    Employee toEntity(EmployeeDTO employeeDTO);
    List<EmployeeDTO> toDtoList(List<Employee> employeeList);

}
