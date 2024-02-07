package com.example.designpattern.pattern.facade.implement1;

public class LoanApprover {
    Asset asset;
    LoanStatus loanStatus;
    public LoanApprover(){
        asset = new Asset();
        loanStatus = new LoanStatus();
    }
    public String CheckLoanEligibility(Person person, double claimAmount){
        String status = " Approved";
        String reason = "";
        String remarks = "";
        System.out.println("\nChecking the loan approval status of " + person.name);
        System.out.println("[The current asset value: "+ person.assetValue + ",\n claim amount: " + claimAmount + ",\n existing loan?: " + person.previousLoanExit + "]");
        if(!asset.hasSufficientAssetValue(person,claimAmount)){
            status = " Not approved";
            reason += "\nInsufficient balance.";
        }
        if(loanStatus.hasPreviousLoans(person)){
            status = " Not approved";
            reason += "\nAn old loan exist.";
        }
        if (!reason.isEmpty()) {
            remarks = String.format("%nRemarks if any:%s",reason);
        }

        return String.format("%s %s",status,remarks);
    }
}
