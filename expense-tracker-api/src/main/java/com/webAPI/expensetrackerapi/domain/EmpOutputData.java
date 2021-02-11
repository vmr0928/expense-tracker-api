package com.webAPI.expensetrackerapi.domain;

import java.util.ArrayList;
import java.util.List;

public class EmpOutputData {

//    private String status;
    private List<Employee> data = new ArrayList<Employee>();

    public List<Employee> getData() {
        return data;
    }

    public void setData(List<Employee> data) {
        this.data = data;
    }
}
