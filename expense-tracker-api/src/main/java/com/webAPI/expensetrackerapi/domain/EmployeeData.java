package com.webAPI.expensetrackerapi.domain;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {

    private String status;
    private List<Employee> data = new ArrayList<Employee>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Employee> getData() {
        return data;
    }

    public void setData(List<Employee> data) {
        this.data = data;
    }
}
