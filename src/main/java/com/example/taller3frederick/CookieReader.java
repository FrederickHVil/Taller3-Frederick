package com.example.taller3frederick;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;

public class CookieReader {

    private HttpServletRequest request;


    public CookieReader(HttpServletRequest request) {
        this.request = request;
    }


    public Optional<String> readCookie(String key) {
        return Arrays.stream(request.getCookies())
                .filter(c -> key.equals(c.getName()))
                .map(Cookie::getValue)
                .findAny();
    }
}
