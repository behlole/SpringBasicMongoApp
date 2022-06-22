package com.tpl.EmployeesBackend.Models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("employee")
public class Employee {
    private String name;
    private Integer employeeId;
    private Integer age;
}
