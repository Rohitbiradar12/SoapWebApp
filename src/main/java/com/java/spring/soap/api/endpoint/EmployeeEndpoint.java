package com.java.spring.soap.api.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.java.spring.soap.api.service.EmployeeService;
import com.java.spring.soap.api.user.GetEmployeeRequest;
import com.java.spring.soap.api.user.GetEmployeeResponse;

@Endpoint
public class EmployeeEndpoint {

    private static final String NAMESPACE_URI = "http://www.java.com/spring/soap/api/user";
    private final EmployeeService employeeService;

    public EmployeeEndpoint(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetEmployeeRequest")
    @ResponsePayload
    public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeRequest request) {
        return employeeService.getEmployeeDetails(request);
    }
}
