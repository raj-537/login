// package com.dcbbank.SpringSecEx.service;

// import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.context.annotation.Bean;
// // import org.springframework.context.annotation.Configuration;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import com.dcbbank.SpringSecEx.model.UserPrincipal;
// import com.dcbbank.SpringSecEx.model.Users;
// import com.dcbbank.SpringSecEx.repo.UserRepo;

// @Service
// public class MyUserDetailService implements UserDetailsService {
//     @Autowired
//     private UserRepo repo;
    
//     @Override
//     public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//         Users user=repo.findByEmail(email);
//         if(user==null) {
//             System.out.println("User not found");
//             throw new UsernameNotFoundException("User not found");
//         }
//         return new UserPrincipal(user);
//     }
    
// }
package com.dcbbank.SpringSecEx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dcbbank.SpringSecEx.model.UserPrincipal;
import com.dcbbank.SpringSecEx.model.Users;
import com.dcbbank.SpringSecEx.repo.UserRepo;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo repo;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Using Optional to check if the user is present
        Optional<Users> optionalUser = repo.findByEmail(email);
        
        // Handle if user is not found
        if (optionalUser.isEmpty()) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        
        // Extracting user from Optional
        Users user = optionalUser.get();
        return new UserPrincipal(user);
    }
}
