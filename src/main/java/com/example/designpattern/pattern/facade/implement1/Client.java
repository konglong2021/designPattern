package com.example.designpattern.pattern.facade.implement1;

public class Client {
    public static void main(String[] args){
        System.out.println("***Simplifying the usage of a complex system using a facade***");
        LoanApprover loanApprover = new LoanApprover();
        Person person = new Person("John Doe", 100000, false);
        checkEligibility(person,200000,loanApprover);
        System.out.println("___________________");
        //Person 2
        person = new Person("Bob Doe", 500, true );
        checkEligibility(person,2000,loanApprover);
        System.out.println("___________________");
        //Person 3
        person = new Person("Tony", 10000, false);
        checkEligibility(person,2000,loanApprover);
        System.out.println("___________________");

    }

    private static void checkEligibility(Person person,
                                         double claimAmount,
                                         LoanApprover loanApprover){
        String approvalStatus = loanApprover.CheckLoanEligibility(person,claimAmount);
        System.out.println(person.name + "'s application status: " + approvalStatus);
    }
}
