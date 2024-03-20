package com.example.emp.exception;

import com.example.emp.dto.EmployeeDTO;
import com.example.emp.mapper.EmployeeMapper;
import com.example.emp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{


    public EmployeeNotFoundException (Long id){
        super("Employee not found with id:"+id);
    }
}
