package com.Jonathan.Prueba.Tecnica.domain.port.out;

import com.Jonathan.Prueba.Tecnica.domain.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeePortOut {
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(long id);
}
