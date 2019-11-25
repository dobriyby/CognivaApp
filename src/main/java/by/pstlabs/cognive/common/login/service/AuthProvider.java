package by.pstlabs.cognive.common.login.service;

import by.pstlabs.cognive.common.model.User;
import by.pstlabs.cognive.microservices.userlist.repository.UserRepository;
import by.pstlabs.cognive.microservices.userlist.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    UserService userService;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        System.out.println(authentication.getPrincipal());
        String password = (String) authentication.getCredentials();
        User user = (User)  userService.loadUserByUsername(name);
        System.out.println("check secure");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            System.out.println(objectMapper.writeValueAsString(authentication));
            System.out.println(objectMapper.writeValueAsString(user));
            System.out.println(objectMapper.writeValueAsString(new UsernamePasswordAuthenticationToken(user,password,user.getAuthorities())));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        if (user == null){
            throw new UsernameNotFoundException("Не найден пользователь");
        }else{
            if(user.getPassword().equals(password) ){
                return new UsernamePasswordAuthenticationToken(user,password,user.getAuthorities());
            }else{
                throw new BadCredentialsException("Неверный пароль");
            }
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
