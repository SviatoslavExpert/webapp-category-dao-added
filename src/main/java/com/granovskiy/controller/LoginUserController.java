package com.granovskiy.controller;

import com.granovskiy.web.Cookie;
import com.granovskiy.web.Request;
import com.granovskiy.web.ViewModel;
import com.granovskiy.model.User;
import com.granovskiy.service.UserService;

public class LoginUserController implements Controller {

    private final UserService userService;

    public LoginUserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ViewModel process(Request req) {
        String username = req.getParam("username")[0];
        String password = req.getParam("password")[0];
        User user = User.of(username, password);

        return userService.authorize(user)
                .map(u -> ViewModel.of("welcome")
                        .withAttribute("user", u)
                        .withCookie(Cookie.of("Mate_Application", u.getToken())))
                .orElseGet(() -> ViewModel.of("login").withAttribute("error", "msg"));
    }
}
