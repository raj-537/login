package com.dcbbank.SpringSecEx.service;
import com.dcbbank.SpringSecEx.dto.*;
// import com.DCB.ecom_pro.dto.CustomerDTO;
// import com.leadid.lead.dto.CustomerDTO;
// import com.DCB.ecom_pro.dto.LoanDTO;
// import com.leadid.lead.dto.LoanDTO;
import com.dcbbank.SpringSecEx.model.*;
// import com.DCB.ecom_pro.model.Customer;
// import com.leadid.lead.model.Customer;
// import com.leadid.lead.model.Customer;
// import com.leadid.lead.model.CustomerDTO;
// import com.dcbbank.SpringSecEx.m.*;
// import com.DCB.ecom_pro.model.Loan;
// import com.leadid.lead.model.Loan;
import com.dcbbank.SpringSecEx.repo.*;
// import com.DCB.ecom_pro.repo.CustomerRepository;
// import com.leadid.lead.repo.CustomerRepository;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(CustomerDTO customerDTO) {
        try {
            Customer customer = new Customer();
            customer.setFinacleCustId(customerDTO.getFinacleCustId());
            customer.setCustomerNme(customerDTO.getCustomerNme());
            customer.setBusinessUnit(customerDTO.getBusinessUnit());
            customer.setBranchName(customerDTO.getBranchName());
            customer.setPrimaryApplicant(customerDTO.getPrimaryApplicant());
            customer.setAccountNameReason(customerDTO.getAccountNameReason());
            customer.setCityOfBusiness(customerDTO.getCityOfBusiness());
            customer.setContactPersonName(customerDTO.getContactPersonName());
            customer.setMobile(customerDTO.getMobile());
            customer.setLandline(customerDTO.getLandline());
            customer.setEmail(customerDTO.getEmail());
            customer.setHrmsId(customerDTO.getHrmsId());
            customer.setSourcingChannel(customerDTO.getSourcingChannel());
            customer.setRmName(customerDTO.getRmName());
            customer.setRemarks(customerDTO.getRemarks());
            customer.setUserType(customerDTO.getUserType());
            customer.setExistingCustomer(customerDTO.getExistingCustomer());

            // Add loans
            Set<Loan> loans = new HashSet<>();
            for (LoanDTO loanDTO : customerDTO.getLoans()) {
                Loan loan = new Loan();
                loan.setLoanType(loanDTO.getLoanType());
                loan.setAmountRequired(loanDTO.getAmountRequired());
                loan.setCustomer(customer);
                loans.add(loan);
            }
            customer.setLoans(loans);

            return customerRepository.save(customer);
        } catch (Exception e) {
            throw new RuntimeException("Error creating customer", e);
        }
    }
}
