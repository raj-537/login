package com.dcbbank.SpringSecEx.config;

import java.io.IOException;

// import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.context.ApplicationContext;

import com.dcbbank.SpringSecEx.service.JWTService;
import com.dcbbank.SpringSecEx.service.MyUserDetailService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class JwtFilter extends OncePerRequestFilter {
     @Autowired
     private JWTService jwtService;
     @Autowired
     ApplicationContext context;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
          String authHeader=request.getHeader("Authorization");
          String token=null;
          String email=null;
          if(authHeader!=null && authHeader.startsWith("Bearer ")){
            token=authHeader.substring(7);
            email=jwtService.extractUserName(token);
          }
          if(email!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetaills=context.getBean(MyUserDetailService.class).loadUserByUsername(email);
             if(jwtService.validateToken(token,userDetaills)){
                UsernamePasswordAuthenticationToken authToken=
                   new UsernamePasswordAuthenticationToken(userDetaills,null,userDetaills.getAuthorities());
                   authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                   SecurityContextHolder.getContext().setAuthentication(authToken);
             }
          }
          filterChain.doFilter(request, response);
        
    }
   
}
