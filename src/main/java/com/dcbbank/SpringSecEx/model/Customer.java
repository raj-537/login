package com.dcbbank.SpringSecEx.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long custId;
       // Enum to define user type
    //    @Enumerated(EnumType.STRING)
    //    @Column(name = "user_type") // Make sure this matches your database column name
       private String userType;
    //    public enum UserType {
    //     INDIVIDUAL,
    //     NON_INDIVIDUAL
    // }
    private boolean existingCustomer;
    public boolean isExistingCustomer() {
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

   

    private Long finacleCustId;
    private String customerNme;

    @Column(nullable = false)
    private String businessUnit;

    @Column(nullable = false)
    private String branchName;

    @Column(nullable = false)
    private String primaryApplicant;

    @Column(nullable = false)
    private String accountNameReason;

    @Column(nullable = false)
    private String cityOfBusiness;

    @Column(nullable = false)
    private String contactPersonName;

    @Column(nullable = false)
    private String mobile;

    private String landline;
    private String email;

    @Column(nullable = false)
    private String hrmsId;

    @Column(nullable = false)
    private String sourcingChannel;

    @Column(nullable = false)
    private String rmName;

    private String remarks;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Loan> loans;

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

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

    public Set<Loan> getLoans() {
        return loans;
    }

    public void setLoans(Set<Loan> loans) {
        this.loans = loans;
    }

    // Getters and setters omitted for brevity
}
