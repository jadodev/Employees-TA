package com.Jonathan.Prueba.Tecnica.infrastructure.service;

import com.Jonathan.Prueba.Tecnica.domain.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ApiServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private CacheManager cacheManager;

    @InjectMocks
    private ApiService apiService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetEmployeeById_FromCache() {
        // Mock del caché
        Cache cache = mock(Cache.class);
        when(cacheManager.getCache("employees")).thenReturn(cache);

        List<Employee> cachedEmployees = Arrays.asList(
                new Employee(1, "John Doe", 30000, 25, ""),
                new Employee(2, "Jane Smith", 50000, 30, "")
        );
        when(cache.get("employees", List.class)).thenReturn(cachedEmployees);

        Optional<Employee> result = apiService.getEmployeeById(1);

        assertTrue(result.isPresent());
        assertEquals(1, result.get().getId());
        assertEquals("John Doe", result.get().getEmployee_name());
    }

    @Test
    void testGetEmployeeById_NotInCache() {
        Cache cache = mock(Cache.class);
        when(cacheManager.getCache("employees")).thenReturn(cache);
        when(cache.get("employees", List.class)).thenReturn(null);

        Optional<Employee> result = apiService.getEmployeeById(1);

        assertFalse(result.isPresent());
    }

}