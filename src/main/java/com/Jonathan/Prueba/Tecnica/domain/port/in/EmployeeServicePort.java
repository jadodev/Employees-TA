package com.Jonathan.Prueba.Tecnica.domain.port.in;

import com.Jonathan.Prueba.Tecnica.domain.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeServicePort {
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(long id);
}

