package onetomanymapping.example.springcontinue.service;

import onetomanymapping.example.springcontinue.entities.ApplicationUser;
import onetomanymapping.example.springcontinue.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ApplicationUserService  implements UserDetailsService  {

 @Autowired
    private ApplicationUserRepository userRepository;
   private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser user = userRepository.findByUsername(username);
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
    public  void  save(ApplicationUser user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

}


