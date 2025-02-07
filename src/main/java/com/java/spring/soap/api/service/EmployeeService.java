package com.java.spring.soap.api.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.java.spring.soap.api.user.GetEmployeeRequest;
import com.java.spring.soap.api.user.GetEmployeeResponse;

@Service
public class EmployeeService {

    private final Map<Integer, GetEmployeeResponse> employeeData = new HashMap<>();

    public EmployeeService() {
        
        employeeData.put(1, createEmployee("Alice", 30, "HR"));
        employeeData.put(2, createEmployee("Bob", 25, "IT"));
        employeeData.put(3, createEmployee("Charlie", 35, "Finance"));
    }

    private GetEmployeeResponse createEmployee(String name, int age, String department) {
        GetEmployeeResponse response = new GetEmployeeResponse();
        response.setName(name);
        response.setAge(age);
        response.setDepartment(department);
        return response;
    }

    public GetEmployeeResponse getEmployeeDetails(GetEmployeeRequest request) {
        return employeeData.getOrDefault(request.getEmployeeId(), createEmployee("Not Found", 0, "N/A"));
    }
    
}
