package com.Jonathan.Prueba.Tecnica.application.dto;

public class EmployeeResponseDto {
    private long id;
    private String employee_name;
    private double employee_salary;
    private int employee_age;
    private String profie_image;
    private double employee_anual_salary;

    public EmployeeResponseDto() {
    }

    public EmployeeResponseDto(long id, String employee_name, double employee_salary, int employee_age, String profie_image, double employee_anual_salary) {
        this.id = id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.profie_image = profie_image;
        this.employee_anual_salary = employee_anual_salary;
    }

    public long getId() {
        return id;
    }


    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public double getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(double employee_salary) {
        this.employee_salary = employee_salary;
    }

    public int getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(int employee_age) {
        this.employee_age = employee_age;
    }

    public String getProfie_image() {
        return profie_image;
    }

    public void setProfie_image(String profie_image) {
        this.profie_image = profie_image;
    }

    public double getEmployee_anual_salary() {
        return employee_anual_salary;
    }

    public void setEmployee_anual_salary(double employee_anual_salary) {
        this.employee_anual_salary = employee_anual_salary;
    }
}