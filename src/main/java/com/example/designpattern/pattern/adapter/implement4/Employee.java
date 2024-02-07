package com.example.designpattern.pattern.adapter.implement4;

/**
 * An existing class used in our system
 * Adaptee class
 */
public class Employee {
    private String fullName;
    private String jobTiltle;
    private String officeLocation;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getJobTiltle() {
        return jobTiltle;
    }

    public void setJobTiltle(String jobTiltle) {
        this.jobTiltle = jobTiltle;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }
}
