package com.example.Employee.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="employee")
public class Employee {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)

private Long id;

public void setId(Long id) {
    this.id = id;
}

public void setFirstname(String firstname) {
    this.firstname = firstname;
}

public void setLastname(String lastname) {
    this.lastname = lastname;
}

public void setEmail(String email) {
    this.email = email;
}

public Long getId() {
    return id;
}

public String getFirstname() {
    return firstname;
}

public String getLastname() {
    return lastname;
}

public String getEmail() {
    return email;
}

@Column(name="first_name")
private String firstname;

@Column(name="last_name")
private String lastname;

@Column(name="email")
private String email;
}
