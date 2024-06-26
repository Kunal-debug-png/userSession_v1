package com.example.user.configuration;

import com.example.user.model.UserDtls;
import com.example.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetialsServiceImpl implements UserDetailsService {
    private UserRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDtls user=userRepo.findByEmail(email);
        if(user!=null)
        {
            return new CustomeUserDetails(user);
        }
        throw new UsernameNotFoundException("User not avail");
    }
}
