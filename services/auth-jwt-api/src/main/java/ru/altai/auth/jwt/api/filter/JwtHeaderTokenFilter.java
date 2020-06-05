package ru.altai.auth.jwt.api.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.altai.auth.jwt.api.AuthProps;
import ru.altai.auth.jwt.api.model.MutableHttpServletRequest;
import ru.altai.auth.jwt.api.utils.CookieUtils;
import ru.altai.auth.jwt.api.config.JwtConfig;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtHeaderTokenFilter implements Filter {

    private final static Logger logger = LogManager.getLogger(JwtHeaderTokenFilter.class);

    private final JwtConfig jwtConfig;

    public JwtHeaderTokenFilter(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        MutableHttpServletRequest mutableRequest = new MutableHttpServletRequest(req);

        HttpServletResponse res = (HttpServletResponse) response;

        String path = req.getRequestURL().toString();
        String lastDir = path.substring(path.lastIndexOf("/"));

        Boolean isLoginPage = path.contains("sign/in") || path.contains("login");
        Boolean islogoutPage = path.contains("logout");

        Object token = null;
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(AuthProps.AUTH_TOKEN)) {
                    if (islogoutPage) {
                        res.addCookie(CookieUtils.deleteForToken());
                    } else if (isLoginPage) {
                        res.addCookie(CookieUtils.deleteForToken());
                    } else {
                        token = jwtConfig.getPrefix() + " " +cookie.getValue();
                    }
                }
            }
        }

        if (token != null) {
            String header = mutableRequest.getHeader(jwtConfig.getHeader());
            if(header == null || !header.startsWith(jwtConfig.getPrefix())) {
                logger.debug("header with token is null or not starts with token prefix");
                mutableRequest.putHeader(jwtConfig.getHeader(), token.toString());
                logger.debug("add token in header");
            } else {
                logger.debug("header contains token");
            }
        } else {
            logger.debug("token is null");
        }

        chain.doFilter(mutableRequest, response);
    }

}
