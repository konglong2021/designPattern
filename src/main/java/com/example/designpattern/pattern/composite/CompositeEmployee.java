package com.example.designpattern.pattern.composite;

import java.util.List;

public class CompositeEmployee implements IEmployee {
    private int employeeCount = 0;
    private String name;
    private String dept;
    private List<IEmployee> controls;
    public CompositeEmployee(String name,String dept){
        this.name = name;
        this.dept = dept;
        controls = new java.util.ArrayList<IEmployee>();
    }

    public void addEmployee(IEmployee employee){
        controls.add(employee);
    }

    public void removeEmployee(IEmployee employee){
        controls.remove(employee);
    }

    @Override
    public void printStructures() {
        System.out.println("\t" + this.name + " works in "+ this.dept);
        for (IEmployee employee : controls) {
            employee.printStructures();
        }
    }

    @Override
    public int getEmployeeCount() {
        employeeCount = controls.size();
        for (IEmployee employee : controls) {
            employeeCount += employee.getEmployeeCount();
        }
        return employeeCount;
    }
}
