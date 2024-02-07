package com.example.designpattern.pattern.facade.implement1;

public class LoanStatus {
    public boolean hasPreviousLoans(Person person){
        System.out.println("Verifying "+ person.name + "'s previous loan(s) status.");
        return person.previousLoanExit;
    }
}
