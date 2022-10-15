package com.example.employee.employee;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Employee {

    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate doe;
    @Transient
    private Integer salary;

    public Employee() {
    }

    public Employee(Long id, String name, String email, LocalDate doe) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.doe = doe;
    }

    public Employee(String name, String email, LocalDate doe) {
        this.name = name;
        this.email = email;
        this.doe = doe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDoe() {
        return doe;
    }

    public void setDoe(LocalDate doe) {
        this.doe = doe;
    }

    public Integer getSalary() {
        Integer timeOfWork = Period.between(doe, LocalDate.now()).getYears();
        return 2500 + (500 * timeOfWork);
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", doe=" + doe +
                ", salary=" + salary +
                '}';
    }
}
