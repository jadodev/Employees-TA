package com.Jonathan.Prueba.Tecnica.application.service;

import com.Jonathan.Prueba.Tecnica.application.dto.EmployeeDto;
import com.Jonathan.Prueba.Tecnica.application.dto.EmployeeResponseDto;
import com.Jonathan.Prueba.Tecnica.domain.entity.Employee;
import com.Jonathan.Prueba.Tecnica.domain.service.EmployeeDomainService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class EmployeeApplicationServiceTest {
    @Mock
    private EmployeeDomainService employeeDomainService;

    @InjectMocks
    private EmployeeApplicationService employeeApplicationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEmployees() {
        List<Employee> mockEmployees = Arrays.asList(
                new Employee(1, "John Doe", 50000, 30, "profile1.jpg"),
                new Employee(2, "Jane Smith", 60000, 40, "profile2.jpg")
        );

        when(employeeDomainService.getAllEmployees()).thenReturn(mockEmployees);

        List<EmployeeDto> employeeDtos = employeeApplicationService.getAlEmployees();

        assertNotNull(employeeDtos);
        assertEquals(2, employeeDtos.size());

        EmployeeDto firstEmployeeDto = employeeDtos.get(0);
        assertEquals(1L, firstEmployeeDto.getId());
        assertEquals("John Doe", firstEmployeeDto.getEmployee_name());
        assertEquals(50000, firstEmployeeDto.getEmployee_salary());
        assertEquals(30, firstEmployeeDto.getEmployee_age());
        assertEquals("profile1.jpg", firstEmployeeDto.getProfie_image());

        verify(employeeDomainService, times(1)).getAllEmployees();
    }

    @Test
    void testGetAllEmployeesEmptyList() {
        when(employeeDomainService.getAllEmployees()).thenReturn(Arrays.asList());

        List<EmployeeDto> employeeDtos = employeeApplicationService.getAlEmployees();

        assertNotNull(employeeDtos);
        assertTrue(employeeDtos.isEmpty());

        verify(employeeDomainService, times(1)).getAllEmployees();
    }

    @Test
    void testGetEmployeeById() {
        Employee mockEmployee = new Employee(1, "John Doe", 50000, 30, "profile1.jpg");

        when(employeeDomainService.getEmployeeById(1L)).thenReturn(Optional.of(mockEmployee));

        Optional<EmployeeResponseDto> employeeResponseDto = employeeApplicationService.getEmployeeById(1L);

        assertTrue(employeeResponseDto.isPresent());
        EmployeeResponseDto dto = employeeResponseDto.get();

        assertEquals(1L, dto.getId());
        assertEquals("John Doe", dto.getEmployee_name());
        assertEquals(50000, dto.getEmployee_salary());
        assertEquals(30, dto.getEmployee_age());
        assertEquals("profile1.jpg", dto.getProfie_image());
        assertEquals(50000 * 12, dto.getEmployee_anual_salary());

        verify(employeeDomainService, times(1)).getEmployeeById(1L);
    }

    @Test
    void testGetEmployeeByIdNotFound() {
        when(employeeDomainService.getEmployeeById(1L)).thenReturn(Optional.empty());

        Optional<EmployeeResponseDto> employeeResponseDto = employeeApplicationService.getEmployeeById(1L);

        assertFalse(employeeResponseDto.isPresent());

        verify(employeeDomainService, times(1)).getEmployeeById(1L);
    }

}
