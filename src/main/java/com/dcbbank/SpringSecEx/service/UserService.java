// package com.dcbbank.SpringSecEx.service;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.core.AuthenticationException;

// import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
// // import org.springframework.security.authentication.AuthenticationManager;
// // import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.stereotype.Service;

// import com.dcbbank.SpringSecEx.model.Users;
// import com.dcbbank.SpringSecEx.repo.UserRepo;
// @Service
// public class UserService {
//     @Autowired
//     private UserRepo repo; 
//     @Autowired
//     private JWTService jwtService;
//     @Autowired
//     AuthenticationManager authManager;

//     private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
//     public Users register(Users user){
//         user.setPassword(encoder.encode(user.getPassword()));
//      return repo.save(user);

//     }
   
// public String verify(Users user) {
//     try {
//         Authentication authentication = authManager.authenticate(
//             new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        
//         if (authentication.isAuthenticated()) {
//             return jwtService.generateToken(user.getEmail());
//         }
//     } catch (AuthenticationException e) {
//         return "failure: " + e.getMessage();
//     }
    
//     return "failure";
// }

// }
package com.dcbbank.SpringSecEx.service;
// package com.dcbbank.SpringSecEx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcbbank.SpringSecEx.exception.EmailConflictException;
import com.dcbbank.SpringSecEx.model.Users;
import com.dcbbank.SpringSecEx.repo.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.stereotype.Service;
// import org.springframework.web.server.ResponseStatusException;
// import org.springframework.http.HttpStatus;

// import com.dcbbank.SpringSecEx.model.Users;
// import com.dcbbank.SpringSecEx.repo.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo repo; 
    @Autowired
    private JWTService jwtService;
    @Autowired
    AuthenticationManager authManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(Users user) {
      if (repo.findByEmail(user.getEmail()).isPresent()) {
            throw new EmailConflictException("Email is already in use");}
       
        
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }


    public String verify(Users user) {
        try {
            Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
            
            if (authentication.isAuthenticated()) {
                return jwtService.generateToken(user.getEmail());
            }
        } catch (AuthenticationException e) {
            // Throwing a ResponseStatusException to indicate unauthorized access
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username or password", e);
        }
        
        // In case of failure to authenticate, throw the exception again
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authentication failed");
    }
}
