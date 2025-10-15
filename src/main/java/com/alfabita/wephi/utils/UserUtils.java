package com.alfabita.wephi.utils;


import com.alfabita.wephi.entity.User;
import com.alfabita.wephi.enums.AuthorityType;
import com.alfabita.wephi.enums.UserType;
import com.alfabita.wephi.security.UserDetailsImpl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Optional;
import java.util.Set;

@Component
public class UserUtils {
    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()[]{}|?";
    public static User getCurrentLoginUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof org.springframework.security.core.userdetails.UserDetails) {
            return ((UserDetailsImpl)principal).getUsers();
        }
        throw new SecurityException("User session expired");
    }
    public static UserDetailsImpl getCurrentPrincipal() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof org.springframework.security.core.userdetails.UserDetails) {
            return ((UserDetailsImpl)principal);
        }
        return null;
    }
    public static boolean isDemoUser() {
        return checkAuthority(AuthorityType.DEMO_USER_AUTHORITY);
    }
    public static boolean isSuperAdmin() {
        return checkAuthority(AuthorityType.SUPER_ADMIN_AUTHORITY);
    }

    public static boolean isReseller() {
        return checkAuthority(AuthorityType.RESELLER_AUTHORITY);
    }
    private static boolean checkAuthority(AuthorityType authorityType) {
        User user = getCurrentLoginUser();
        assert user != null;
        Set<SimpleGrantedAuthority> authorities = user.getAuthorities();
        Optional<SimpleGrantedAuthority> auth = authorities.stream().filter(e-> e.getAuthority().equalsIgnoreCase(authorityType.name())).findFirst();
        return auth.isPresent();
    }
    public static String generatePassword(int... length) {
        int len;
        if(null == length || length.length<1)
            len = 6;
        else
            len = length[0];

        String allChars = LOWERCASE_CHARS + UPPERCASE_CHARS + DIGITS + SPECIAL_CHARS;
        SecureRandom random = new SecureRandom();

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < len; i++) {
            int randomIndex = random.nextInt(allChars.length());
            password.append(allChars.charAt(randomIndex));
        }

        return password.toString();
    }

    public static boolean isInternalUser(User user) {
        return checkUser(user,UserType.INTERNAL);
    }
    public static boolean isReseller(User user) {
        return checkUser(user,UserType.RESELLER);
    }
    public static boolean checkUser(User user, UserType userType) {
        if(null == user) throw new NullPointerException("User is null");
        if(null == user.getUserType()) return true;
        return userType.name().equals(user.getUserType());
    }
}
