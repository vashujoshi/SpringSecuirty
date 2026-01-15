package com.example.Employee.Services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.Employee.Entity.Employee;
import com.example.Employee.Repository.EmployeeRepository;

@Service
public class EmployeeServices {
    
    public final EmployeeRepository employeerepository;

    public EmployeeServices(EmployeeRepository employeerepository) {
        this.employeerepository = employeerepository;
    }

    public List<Employee> getallemployees(){
        return employeerepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeerepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee addEmployee(Employee employee) {
         employee.setId(null);
         return employeerepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
    return employeerepository.save(employee);   // ID must remain unchanged
}


    public void deleteEmployee(Long id) {
         if (!employeerepository.existsById(id)) {
        throw new RuntimeException("Employee not found with ID: " + id);
    }
    employeerepository.deleteById(id);
    }


    public Employee patchEmployee(Long id, Map<String, Object> updates) {

    Employee employee = employeerepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Employee not found"));
    updates.forEach((key, value) -> {
        switch (key) {
            case "firstname" -> employee.setFirstname((String) value);
            case "lastname" -> employee.setLastname((String) value);
            case "email" -> employee.setEmail((String) value);
        }
    });

    return employeerepository.save(employee);
}

}
