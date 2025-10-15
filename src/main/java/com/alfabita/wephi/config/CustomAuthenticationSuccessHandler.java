package com.alfabita.wephi.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        String targetUrl = (String) request.getSession().getAttribute("targetUrl");

        if("/".equalsIgnoreCase(targetUrl)) response.sendRedirect("/login/success");
        if (targetUrl != null) {
            response.sendRedirect(targetUrl);
        } else {
            response.sendRedirect("/login/success");
        }
    }


}

