package com.dcbbank.SpringSecEx.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserDetailsService userDetailService;
    @Autowired
    private JwtFilter jwtFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
    return  http  
         .csrf(customizer->customizer.disable())
         .authorizeHttpRequests(request->request
         .requestMatchers("register","login")
         .permitAll()
         .anyRequest().authenticated())
         .cors(Customizer.withDefaults()) // Enable CORS with defaults
        //  http.formLogin(Customizer.withDefaults());
         .httpBasic(Customizer.withDefaults())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class)
        .build();
        // Customizer<CsrfConfigurer<HttpSecurity>> custCsrf=new Customizer<CsrfConfigurer<HttpSecurity>>() {
        //    @Override
        //    public void customize(CsrfConfigurer<HttpSecurity> cutomizer) {
        //     cutomizer.disable();
        // }};
        //   http.csrf(custCsrf);
        //  return http.build();
        // @Bean
        // public UserDetailsService userDetailService(){
        //     return new InMemoryUserDetailsManager();
        // }
       
}
//   @Bean
//     public UserDetailsService userDetailService() {
//         UserDetails user1 = User.builder()  // Use correct 'User' class from org.springframework.security.core.userdetails.User
//                 .username("raj")
//                 .password(passwordEncoder().encode("r@123"))
//                 .roles("USER")
//                 .build();
//         UserDetails user2 = User.builder()  // Use correct 'User' class from org.springframework.security.core.userdetails.User
//                 .username("prinshu")
//                 .password(passwordEncoder().encode("p@123"))
//                 .roles("USER")
//                 .build();

//         return new InMemoryUserDetailsManager(user1, user2);
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

@Bean 
 public AuthenticationProvider authenticationProvider(){
    DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
    provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
    provider.setUserDetailsService(userDetailService);
    return provider;
}
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
       return config.getAuthenticationManager();
    }
}


