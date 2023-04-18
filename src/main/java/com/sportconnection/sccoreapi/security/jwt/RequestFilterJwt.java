package com.sportconnection.sccoreapi.security.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
public class RequestFilterJwt extends OncePerRequestFilter {

    private UserDetailsServiceJwt userDetailsServiceJwt;
    private SecretJwt secretJwt;

    public RequestFilterJwt(UserDetailsServiceJwt userDetailsServiceJwt,
                            SecretJwt secretJwt){
        this.userDetailsServiceJwt = userDetailsServiceJwt;
        this.secretJwt = secretJwt;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String requestToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        String username = null;
        String token;

        if(requestToken != null && requestToken.startsWith("Bearer")) {
            token = requestToken.replace("Bearer ", "");
            try {
                username = this.secretJwt.getUsername(token);
            }catch(IllegalArgumentException iaEx) {
                log.error("Unable to parse JWT token", iaEx);
            }catch(ExpiredJwtException ejEx) {
                log.error("JWT Token has expired", ejEx);
            }
        }else {
            log.info("The informed Token is not of the Bearer type");
        }

        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsServiceJwt.loadUserByUsername(username);

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.getAuthorities()
            );

            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(request, response);
    }

}
