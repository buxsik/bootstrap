package com.rakitov.bootstrap.config.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Component
public class LoginSuccesHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        Collection<? extends GrantedAuthority> grantedAuthorities = authentication.getAuthorities();

        boolean isUser = false;
        boolean isAdmin = false;
        for (GrantedAuthority granted : grantedAuthorities) {
            if (granted.getAuthority().contains("ROLE_USER")) {
                isUser = true;
            }
            if (granted.getAuthority().contains("ROLE_ADMIN")) {
                isAdmin = true;
            }
         }
        if (isAdmin) {
            httpServletResponse.sendRedirect("admin");
            return;
        }
        if (isUser) {
            httpServletResponse.sendRedirect("user");
        }
    }
}
