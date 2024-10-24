package com.dcbbank.SpringSecEx.repo;


// import com.leadid.lead.model.Customer;
import com.dcbbank.SpringSecEx.model.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
