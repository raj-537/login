package com.dcbbank.SpringSecEx.model;

import java.util.Collection;
import java.util.Collections;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

// import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
// import org.hibernate.engine.internal.Collections;
import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {
    private Users user;
    public UserPrincipal(Users user){
          this.user=user;  
     }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
        // throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
    }

    @Override
    public String getPassword() {
       
        return user.getPassword();
        // throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
    }

    @Override
    public String getUsername() {
         return user.getEmail();
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
    }
    @Override 
    public boolean isAccountNonExpired(){
        return true;
        
    }
    @Override 
    public boolean isAccountNonLocked(){
        return true;
        
    }
    
    @Override 
    public boolean isCredentialsNonExpired(){
        return true;
        
    }
    @Override
    public boolean isEnabled(){
        return true;
    }

   
    

}
