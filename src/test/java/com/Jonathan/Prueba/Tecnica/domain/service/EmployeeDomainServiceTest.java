package com.Jonathan.Prueba.Tecnica.domain.service;

import com.Jonathan.Prueba.Tecnica.domain.entity.Employee;
import com.Jonathan.Prueba.Tecnica.domain.port.out.EmployeePortOut;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

public class EmployeeDomainServiceTest {
    @Mock
    private EmployeePortOut employeePortOut;

    @InjectMocks
    private EmployeeDomainService employeeDomainService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEmployees() {
        List<Employee> mockEmployees = Arrays.asList(
                new Employee(1, "John Doe", 50000, 30, "profile1.jpg"),
                new Employee(2, "Jane Doe", 60000, 25, "profile2.jpg")
        );

        when(employeePortOut.getAllEmployees()).thenReturn(mockEmployees);

        List<Employee> employees = employeeDomainService.getAllEmployees();

        assertNotNull(employees);
        assertEquals(2, employees.size());
        assertEquals("John Doe", employees.get(0).getEmployee_name());

        verify(employeePortOut, times(1)).getAllEmployees();
    }

    @Test
    void testGetEmployeeById() {
        Employee mockEmployee = new Employee(1, "John Doe", 50000, 30, "profile1.jpg");

        when(employeePortOut.getEmployeeById(1L)).thenReturn(Optional.of(mockEmployee));

        Optional<Employee> employee = employeeDomainService.getEmployeeById(1L);

        assertTrue(employee.isPresent());
        assertEquals(1L, employee.get().getId());
        assertEquals("John Doe", employee.get().getEmployee_name());

        verify(employeePortOut, times(1)).getEmployeeById(1L);
    }

    @Test
    void testGetEmployeeByIdNotFound() {
        when(employeePortOut.getEmployeeById(1L)).thenReturn(Optional.empty());

        Optional<Employee> employee = employeeDomainService.getEmployeeById(1L);

        assertFalse(employee.isPresent());

        verify(employeePortOut, times(1)).getEmployeeById(1L);
    }
}
