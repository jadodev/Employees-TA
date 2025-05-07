# Prueba Tecnica - Empleados

## Arquitectura 

# -Este Proyecto fue diseñado con una arquitectura hexagonal que permite su escalabilidad y mantenibilidad de codigo sencilla, además de gran desacomplamiento de las capas de dominio, aplicacion e infrasestructura.

```bash
  └── src/
    ├── main/
    │   ├── java/
    │   │   └── com/
    │   │       └── Jonathan/
    │   │           └── Prueba/
    │   │               └── Tecnica/
    │   │                   ├── PruebaTecnicaApplication.java
    │   │                   ├── ServletInitializer.java
    │   │                   │
    │   │                   ├── application/
    │   │                   │   ├── dto/
    │   │                   │   │   ├── EmployeeDto.java
    │   │                   │   │   └── EmployeeResponseDto.java
    │   │                   │   ├── mapper/
    │   │                   │   │   └── EmployeeMapper.java
    │   │                   │   └── service/
    │   │                   │       └── EmployeeApplicationService.java
    │   │                   │
    │   │                   ├── domain/
    │   │                   │   ├── entity/
    │   │                   │   │   └── Employee.java
    │   │                   │   ├── port/
    │   │                   │   │   ├── in/
    │   │                   │   │   │   └── EmployeeServicePort.java
    │   │                   │   │   └── out/
    │   │                   │   │       └── EmployeePortOut.java
    │   │                   │   └── service/
    │   │                   │       └── EmployeeDomainService.java
    │   │                   │
    │   │                   ├── infrastructure/
    │   │                   │   ├── config/
    │   │                   │   │   └── beans/
    │   │                   │   │       ├── CacheConfig.java
    │   │                   │   │       └── RestTemplateConfig.java
    │   │                   │   ├── controller/
    │   │                   │   │   └── EmployeeController.java
    │   │                   │   ├── entity/
    │   │                   │   │   ├── EmployeApiResponse.java
    │   │                   │   │   ├── EmployeeById.java
    │   │                   │   │   └── EmployeeExternalDto.java
    │   │                   │   ├── mapper/
    │   │                   │   │   └── EmployeeMapperInfra.java
    │   │                   │   └── service/
    │   │                   │       └── ApiService.java
    │
    │   └── resources/
    │       ├── application.properties
    │       └── (otros recursos como logback.xml, etc.)
    │
    └── test/
        └── java/
            └── com/
                └── Jonathan/
                    └── Prueba/
                        └── Tecnica/
                            ├── PruebaTecnicaApplicationTests.java
                            ├── application/
                            │   └── service/
                            │       └── EmployeeApplicationServiceTest.java
                            ├── domain/
                            │   └── service/
                            │       └── EmployeeDomainServiceTest.java
                            └── infrastructure/
                                ├── controller/
                                │   └── EmployeeControllerTest.java
                                └── service/
                                    └── ApiServiceTest.java
```

## Patrones de Diseño

# Implementación de patrones de diseño como DTO, Mapper, Inyeccion de Dependencias.

# Tecnologias implementadas

### Implementacion de Spring Boot, Caffein para el cache en memoria, Creacion de Beans para configuraciones, Jnit y Mockito para testing 
