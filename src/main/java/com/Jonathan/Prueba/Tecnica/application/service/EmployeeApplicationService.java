package com.Jonathan.Prueba.Tecnica.application.service;

import com.Jonathan.Prueba.Tecnica.application.dto.EmployeeDto;
import com.Jonathan.Prueba.Tecnica.application.dto.EmployeeResponseDto;
import com.Jonathan.Prueba.Tecnica.application.mapper.EmployeeMapper;
import com.Jonathan.Prueba.Tecnica.domain.entity.Employee;
import com.Jonathan.Prueba.Tecnica.domain.service.EmployeeDomainService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeApplicationService {
    private final EmployeeDomainService employeeDomainService;

    public EmployeeApplicationService(EmployeeDomainService employeeDomainService) {
        this.employeeDomainService = employeeDomainService;
    }

    public List<EmployeeDto> getAlEmployees() {
        List<Employee> employees = employeeDomainService.getAllEmployees();
        return employees.stream()
                        .map(EmployeeMapper::toDto)
                        .collect(Collectors.toList());
    }

    public Optional<EmployeeResponseDto> getEmployeeById(long id){
        Optional<Employee> employee = employeeDomainService.getEmployeeById(id);
        return employee.map(EmployeeMapper::toResponse);
    }
}
