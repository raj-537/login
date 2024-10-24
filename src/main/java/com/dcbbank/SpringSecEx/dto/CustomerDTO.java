package com.dcbbank.SpringSecEx.dto;

import java.util.List;

public class CustomerDTO {

    private Long finacleCustId;
    private String customerNme;
    private String businessUnit;
    private String branchName;
    private String primaryApplicant;
    private String accountNameReason;
    private String cityOfBusiness;
    private String contactPersonName;
    private String mobile;
    private String landline;
    private String email;
    private String hrmsId;
    private String sourcingChannel;
    private String rmName;
    private String remarks;
    private String userType;
   private boolean existingCustomer;
    public boolean getExistingCustomer() {
    return existingCustomer;
}

public void setExistingCustomer(boolean existingCustomer) {
    this.existingCustomer = existingCustomer;
}

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    private List<LoanDTO> loans;

    public Long getFinacleCustId() {
        return finacleCustId;
    }

    public void setFinacleCustId(Long finacleCustId) {
        this.finacleCustId = finacleCustId;
    }

    public String getCustomerNme() {
        return customerNme;
    }

    public void setCustomerNme(String customerNme) {
        this.customerNme = customerNme;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getPrimaryApplicant() {
        return primaryApplicant;
    }

    public void setPrimaryApplicant(String primaryApplicant) {
        this.primaryApplicant = primaryApplicant;
    }

    public String getAccountNameReason() {
        return accountNameReason;
    }

    public void setAccountNameReason(String accountNameReason) {
        this.accountNameReason = accountNameReason;
    }

    public String getCityOfBusiness() {
        return cityOfBusiness;
    }

    public void setCityOfBusiness(String cityOfBusiness) {
        this.cityOfBusiness = cityOfBusiness;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHrmsId() {
        return hrmsId;
    }

    public void setHrmsId(String hrmsId) {
        this.hrmsId = hrmsId;
    }

    public String getSourcingChannel() {
        return sourcingChannel;
    }

    public void setSourcingChannel(String sourcingChannel) {
        this.sourcingChannel = sourcingChannel;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<LoanDTO> getLoans() {
        return loans;
    }

    public void setLoans(List<LoanDTO> loans) {
        this.loans = loans;
    }

    // Getters and setters omitted for brevity
}
