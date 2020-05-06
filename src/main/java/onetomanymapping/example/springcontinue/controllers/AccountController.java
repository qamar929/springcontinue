package onetomanymapping.example.springcontinue.controllers;

import onetomanymapping.example.springcontinue.service.ApplicationUserService;
import onetomanymapping.example.springcontinue.service.JwtUtilService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import onetomanymapping.example.springcontinue.entities.ApplicationUser;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AuthenticationManager authenticationManager;
@Autowired
    private JwtUtilService jwtUtil;

@Autowired

private ApplicationUserService userService;
    @PostMapping
    public String login(@RequestBody ApplicationUser user) throws Exception
    {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

        }catch (Exception e)
        {
            throw  new Exception("Invalid credentials");
        }
        return jwtUtil.generateToken(user.getUsername());
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody ApplicationUser user)
    {
userService.save(user);
return  new ResponseEntity<String>("user created", HttpStatus.CREATED);

    }
}
