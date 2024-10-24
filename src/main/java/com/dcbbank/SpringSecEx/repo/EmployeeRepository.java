package com.dcbbank.SpringSecEx.repo;

import com.dcbbank.SpringSecEx.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findById(Long employeeId);
}
