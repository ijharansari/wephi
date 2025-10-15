package com.alfabita.wephi.service;


import org.springframework.security.core.userdetails.UserDetails;

public interface UsersService{
    UserDetails findByEmailOrMobile(String username);
}
