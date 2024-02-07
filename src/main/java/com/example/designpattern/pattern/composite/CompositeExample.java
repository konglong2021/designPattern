package com.example.designpattern.pattern.composite;

/****
 * Composite use for accessing tree structures
 *  the patterns provide for accessing like branches and leaf(nodes) of the tree
 */

public class CompositeExample {
    public static void main(String[] args) {
        System.out.println("***Composite Pattern Example***");
        Employee mathTeacher1 = new Employee("Math Teacher 1", "Maths");
        Employee mathTeacher2 = new Employee("Math Teacher 2", "Maths");

        Employee cseTeacher1 = new Employee("CSE Teacher 1", "Computer SE");
        Employee cseTeacher2 = new Employee("CSE Teacher 2", "Computer SE");
        Employee cseTeacher3 = new Employee("CSE Teacher 3", "Computer SE");

        CompositeEmployee hodMaths = new CompositeEmployee("HOD Maths", "Maths");
        CompositeEmployee hodCompSc = new CompositeEmployee("HOD Computer Science", "Computer Science");

        CompositeEmployee principal = new CompositeEmployee("Dr.S.Som(Principal)", "Planning-Supervising-Managing");

        hodMaths.addEmployee(mathTeacher1);
        hodMaths.addEmployee(mathTeacher2);

        hodCompSc.addEmployee(cseTeacher1);
        hodCompSc.addEmployee(cseTeacher2);
        hodCompSc.addEmployee(cseTeacher3);

        principal.addEmployee(hodMaths);
        principal.addEmployee(hodCompSc);
        System.out.println("\n Testing the structure of a Principle object");
        principal.printStructures();
        System.out.println("At present Principal has control over " + principal.getEmployeeCount() + " employees");
        System.out.println("\n Testing the structure of a HOD-CSE object");
        hodCompSc.printStructures();
        System.out.println("At present HOD-CSE has control over " + hodCompSc.getEmployeeCount() + " employees");
        System.out.println("\n Testing the structure of a HOD-Maths object");
        hodMaths.printStructures();
        System.out.println("At present HOD-Maths has control over " + hodMaths.getEmployeeCount() + " employees");
        System.out.println("\n Testing the structure of a leaf node");
        mathTeacher1.printStructures();
        System.out.println("At present leaf node has control over " + mathTeacher1.getEmployeeCount() + " employees");
        hodCompSc.removeEmployee(cseTeacher2);
        System.out.println("\n After CSE Teacher-2 resigned, the organisation has following members:");
        principal.printStructures();
        System.out.println("At present Principal has control over " + principal.getEmployeeCount() + " employees");
        System.out.println("At present HOD-CSE has control over " + hodCompSc.getEmployeeCount() + " employees");
        System.out.println("At present HOD-Maths has control over " + hodMaths.getEmployeeCount() + " employees");
    }
}
