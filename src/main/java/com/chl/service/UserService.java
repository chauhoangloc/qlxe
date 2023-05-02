package com.chl.service;

import com.chl.pojo.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public Users getUserByUsername(String username);
}
