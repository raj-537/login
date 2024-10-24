package com.dcbbank.SpringSecEx.repo;
import com.dcbbank.SpringSecEx.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
