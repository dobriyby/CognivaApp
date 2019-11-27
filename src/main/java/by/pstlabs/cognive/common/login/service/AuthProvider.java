package by.pstlabs.cognive.common.login.service;

import by.pstlabs.cognive.common.model.User;
import by.pstlabs.cognive.microservices.userlist.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    UserService userService;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String name = authentication.getName();
        String password = (String) authentication.getCredentials();
        ObjectMapper ob= new ObjectMapper();
        try {
            System.out.println(ob.writeValueAsString(authentication));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        User user = (User)  userService.loadUserByUsername(name);
        System.out.println("check secure");
        if (user == null){
                throw new UsernameNotFoundException("Не найден пользователь");
        }else{
            if(user.getPassword().equals(password) ){
                Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
                return new UsernamePasswordAuthenticationToken(user,password,authorities);
            }else{
                    throw new CredentialsExpiredException("Неверный пароль");
            }
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
