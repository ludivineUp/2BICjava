package com.bookstore.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class JWTTokenFilter extends OncePerRequestFilter {
	
	private JWTTokenProvider provider;
	
	public JWTTokenFilter(JWTTokenProvider p) {
		this.provider = p;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filter) throws ServletException, IOException{
		String token = provider.resolveToken(req);	
		try {
				if(token != null&& provider.validatToken(token)) {
					Authentication auth = provider.getAuthentication(token);
					SecurityContextHolder.getContext().setAuthentication(auth);
				}
			} catch (Exception e) {
				SecurityContextHolder.clearContext();
				res.sendError(403, "bad token");
			}
		filter.doFilter(req, res);
	}

}
