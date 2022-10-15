package com.example.employee.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EmployeeConfig {

    CommandLineRunner commandLineRunner(EmployeeRepository repository) {
        return args -> {
            Employee ann = new Employee(
                    "Ann",
                    "ann1@gmail.com",
                    LocalDate.of(2020, Month.JANUARY, 15)
            );
            Employee will = new Employee(
                    "Will",
                    "will1@gmail.com",
                    LocalDate.of(2021, Month.JANUARY, 15)
            );
            repository.saveAll(
                    List.of(ann, will)
            );
        };
    }
}
