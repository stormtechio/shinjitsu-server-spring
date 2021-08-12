package com.stormtechio.shinjitsu.security;

import com.stormtechio.shinjitsu.model.User;
import com.stormtechio.shinjitsu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
class ShinjitsuUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("User was not found in the database");
        }

        return user;
    }
}
