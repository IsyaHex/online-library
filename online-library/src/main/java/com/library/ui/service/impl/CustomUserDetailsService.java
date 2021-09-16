package com.library.ui.service.impl;

import com.library.ui.constant.UserStateEnum;
import com.library.ui.domain.CustomUserDetails;
import com.library.ui.domain.User;
import com.library.ui.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;

@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) {
        log.debug("Trying to login with credentials {}", s);
        if(s == null || s.isBlank()) {
            throw new UsernameNotFoundException(s);
        }
        User user = userRepository.findByUsername(s);
        if(user == null)
            throw new UsernameNotFoundException(s);
        if(user.getState() == null || user.getState() != UserStateEnum.ACTIVE.getState().intValue()) {
            throw new UsernameNotFoundException(s);
        }
        log.debug("Logged in at " + LocalDateTime.now() + " " + s);

        return new CustomUserDetails(s, user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority("ROLE_" +
                        user.getRole().getName().toUpperCase())), user.getName());
    }
}
