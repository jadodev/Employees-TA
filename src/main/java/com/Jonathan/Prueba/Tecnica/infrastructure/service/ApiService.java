package com.Jonathan.Prueba.Tecnica.infrastructure.service;

import com.Jonathan.Prueba.Tecnica.domain.entity.Employee;
import com.Jonathan.Prueba.Tecnica.domain.port.out.EmployeePortOut;
import com.Jonathan.Prueba.Tecnica.infrastructure.entity.EmployeApiResponse;
import com.Jonathan.Prueba.Tecnica.infrastructure.entity.EmployeeExternalDto;
import com.Jonathan.Prueba.Tecnica.infrastructure.mapper.EmployeeMapperInfra;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ApiService implements EmployeePortOut {
    private final RestTemplate restTemplate;
    private final CacheManager cacheManager;

    public ApiService(RestTemplate restTemplate, CacheManager cacheManager) {
        this.restTemplate = restTemplate;
        this.cacheManager = cacheManager;
    }
    @Override
    @Cacheable(value = "employees", key = "'employees'")
    public List<Employee> getAllEmployees() {
        ResponseEntity<EmployeApiResponse> response = restTemplate.exchange(
                "https://dummy.restapiexample.com/api/v1/employees",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<EmployeApiResponse>() {}
        );

        List<EmployeeExternalDto> externalEmployees = response.getBody().getData();
        return EmployeeMapperInfra.toDomainList(externalEmployees);
    }

    public Optional<Employee> getEmployeeById(long id) {
        Cache employeesCache = cacheManager.getCache("employees");
        if (employeesCache != null) {
            List<Employee> cachedEmployees = employeesCache.get("employees", List.class);
            if (cachedEmployees != null) {
                return cachedEmployees.stream()
                        .filter(employee -> employee.getId() == id)
                        .findFirst();
            }
        }
        return Optional.empty();
    }

}
