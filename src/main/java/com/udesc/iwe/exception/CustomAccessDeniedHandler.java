package com.udesc.iwe.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler{

	@Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();


        if (auth != null) {
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Você não tem permissão para acessar este recurso.");
        } else {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Acesso negado.");
        }
    }



}
