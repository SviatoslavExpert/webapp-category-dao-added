package com.granovskiy.web;

import com.granovskiy.Factory;
import com.granovskiy.model.User;
import com.granovskiy.service.UserService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class UserFilter implements Filter {

    private Set<String> openUri = new HashSet<>();

    private UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        openUri.add("/servlet/login");
        openUri.add("/servlet/register");
        userService = Factory.getUserServiceImpl(Factory.getUserDaoImpl(Factory.getConnection()));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        Cookie[] cookies = req.getCookies();

        if (openUri.contains(req.getRequestURI())) {
            processRequest(request, response, chain);
        } else {
            Optional<User> user = Stream.of(cookies)
                    .filter(c -> c.getName().equals("Mate_Application"))
                    .findFirst()
                    .map(Cookie::getValue)
                    .flatMap(userService::findByToken);

            if (user.isPresent()) {
                processRequest(request, response, chain);
            } else {
                req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, response);
            }
        }
    }

    @Override
    public void destroy() {

    }

    private void processRequest(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
    }
}
