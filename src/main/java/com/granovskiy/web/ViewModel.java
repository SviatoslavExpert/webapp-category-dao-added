package com.granovskiy.web;

import java.util.*;

public class ViewModel {
    private final String view;
    private final Map<String, Object> attributes = new HashMap<>();
    private final String REDIRECT_TEMPLATE = "/WEB-INF/views/%s.jsp";
    private final List<Cookie> cookies = new ArrayList<>();

    public ViewModel(String view) {
        this.view = view;
    }

    public String getView() {
        return view;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public static ViewModel of(String view) {
        return new ViewModel(view);
    }

    public String getRedirectUri() {
        return String.format(REDIRECT_TEMPLATE, view);
    }

    public List<Cookie> getCookies() {
        return new ArrayList<>(cookies);
    }

    public ViewModel withAttribute(String name, Object o) {
        this.attributes.put(name, o);
        return this;
    }

    public ViewModel withCookie(Cookie cookie) {
        cookies.add(cookie);
        return this;
    }
}
