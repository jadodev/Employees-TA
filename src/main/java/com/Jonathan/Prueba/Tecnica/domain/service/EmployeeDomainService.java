package com.Jonathan.Prueba.Tecnica.domain.service;

import com.Jonathan.Prueba.Tecnica.domain.entity.Employee;
import com.Jonathan.Prueba.Tecnica.domain.port.out.EmployeePortOut;
import com.Jonathan.Prueba.Tecnica.domain.port.in.EmployeeServicePort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeDomainService implements EmployeeServicePort  {
    private final EmployeePortOut employeePortOut;

    public EmployeeDomainService(EmployeePortOut employeePortOut) {
        this.employeePortOut = employeePortOut;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeePortOut.getAllEmployees();
    }

    @Override
    public Optional<Employee> getEmployeeById(long id) {
        return employeePortOut.getEmployeeById(id);
    }

}
