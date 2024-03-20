package com.example.emp.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

public class EmployeeDTO {
    @Id
    private Long id;
    @NotNull(message = "FirstName cannot be empty")
    private String firstName;
    @NotNull(message = "LastName cannot be empty")
    private String lastName;
    @NotNull(message = "Email cannot be empty")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
