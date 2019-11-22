package by.pstlabs.cognive.common.login;

import by.pstlabs.cognive.common.login.service.AuthProvider;
import by.pstlabs.cognive.common.login.service.LoginService;
import by.pstlabs.cognive.microservices.userlist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration

public class SecureConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthProvider authProvider;

//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Bean
//    PasswordEncoder PasswordEncoder(){
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        return passwordEncoder;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth){
//        auth.authenticationProvider(authProvider);
//    }
//
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/**").permitAll()
                .antMatchers(HttpMethod.POST,"/**").permitAll()
                .and().cors()
                .and().csrf().disable();
    }


}
