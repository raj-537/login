package com.dcbbank.SpringSecEx.repo;

import java.util.Optional; // Correct import
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dcbbank.SpringSecEx.model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    Optional<Users> findByEmail(String email); // Returns java.util.Optional
}
