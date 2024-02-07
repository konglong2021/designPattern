package com.example.designpattern.pattern.adapter.implement4;

public class EmployeeClassAdapter extends Employee implements Customer{
    @Override
    public String getName() {
        return this.getFullName();
    }

    @Override
    public String getDesignation() {
        return this.getJobTiltle();
    }

    @Override
    public String getAddress() {
        return this.getOfficeLocation();
    }
}
