package com.dcbbank.SpringSecEx.dto;

public class LoanDTO {

    private String loanType;
    private Double amountRequired;
    public String getLoanType() {
        return loanType;
    }
    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }
    public Double getAmountRequired() {
        return amountRequired;
    }
    public void setAmountRequired(Double amountRequired) {
        this.amountRequired = amountRequired;
    }

    // Getters and setters omitted for brevity
}
