package details.Techcorp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

@Configuration
@EnableWebSecurity
public class appconfiguration {
    @Autowired
    SERVICECLASS serv;


    AuthenticationManager manager;
    @Bean
    public InMemoryUserDetailsManager users(){
        UserDetails user1= User.withUsername("tamil").password(crpter().encode("password123")).roles("user").build();
        UserDetails user2=User.withUsername("siva").password(crpter().encode("pass123")).roles("user").build();
        Collection<UserDetails> allusers= Stream.of(user1,user2).toList();
        return new InMemoryUserDetailsManager(allusers);
    }
    @Bean
    public PasswordEncoder crpter(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public WebSecurityCustomizer customize()
    {
        return (web) -> web.ignoring().requestMatchers("/employee/create");
    }
    @Bean
    @Deprecated(since = "6.1",forRemoval = true)
    public SecurityFilterChain secure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().authenticated();
//        http.authorizeRequests().anyRequest().permitAll();
        http.authorizeRequests().requestMatchers("/employee/**").authenticated();
        http.cors();
        http.csrf().disable();
        http.httpBasic();
        http.formLogin();

        AuthenticationManagerBuilder builder=http.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(serv).passwordEncoder(crpter());
        manager=builder.build();
        http.authenticationManager(manager);
        return http.build();
    }
}
