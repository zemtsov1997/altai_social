package ru.altai.auth.jwt.api.utils;

import ru.altai.auth.jwt.api.AuthProps;

import javax.servlet.http.Cookie;

public class CookieUtils {

    public static Cookie createForToken(String tokenValue) {
        Cookie cookie = new Cookie(AuthProps.AUTH_TOKEN, tokenValue);
        cookie.setMaxAge(60*60*24);
        cookie.setPath("/");
        return cookie;
    }

    public static Cookie deleteForToken() {
        Cookie cookie = new Cookie(AuthProps.AUTH_TOKEN, "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        return cookie;
    }


}
