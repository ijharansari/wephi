package com.alfabita.wephi.service.impl;


import com.alfabita.wephi.constant.ErrorMessageKey;
import com.alfabita.wephi.entity.User;
import com.alfabita.wephi.repository.UsersRepository;
import com.alfabita.wephi.security.UserDetailsImpl;
import com.alfabita.wephi.service.UsersService;
import com.alfabita.wephi.utils.LocaleUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);
    private final UsersRepository usersRepository;
    private final LocaleUtils localeUtils;
    public UsersServiceImpl(UsersRepository usersRepository,
                            LocaleUtils localeUtils) {
        this.usersRepository = usersRepository;
        this.localeUtils = localeUtils;
    }

    @Override
    public UserDetails findByEmailOrMobile(String username) {
        boolean isEmail = username.contains("@");
        boolean isMobile = username.matches("^\\d{7,15}$");

        User user;
        if (isEmail) {
            user = usersRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(
                    localeUtils.getMessage(ErrorMessageKey.USER_NOT_FOUND_KEY)));
        } else if (isMobile) {
            user = usersRepository.findByPhone(username).orElseThrow(() -> new UsernameNotFoundException(
                    localeUtils.getMessage(ErrorMessageKey.USER_NOT_FOUND_KEY)));
        }else {
            throw new UsernameNotFoundException(localeUtils.getMessage(ErrorMessageKey.USER_NOT_FOUND_KEY));
        }
        return new UserDetailsImpl(user);
    }
}
