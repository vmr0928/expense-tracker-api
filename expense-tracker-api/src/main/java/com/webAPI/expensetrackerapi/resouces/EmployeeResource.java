package com.webAPI.expensetrackerapi.resouces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.webAPI.expensetrackerapi.domain.EmpOutputData;


@RestController
@RequestMapping("/Employees")
public class EmployeeResource {

    static final String url = "http://dummy.restapiexample.com/api/v1/employees";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/list")
    public ResponseEntity<EmpOutputData> getDataFromAPI(){

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<EmpOutputData> request = new HttpEntity<>(headers);

        ResponseEntity<EmpOutputData> response = restTemplate.exchange(url, HttpMethod.GET, request, EmpOutputData.class);

        return response;
    }


}
