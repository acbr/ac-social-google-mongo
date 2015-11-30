package com.avenuecode.signin;

/**
 * Created by ac-jlima on 11/29/15.
 */


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.util.CookieGenerator;
import javax.servlet.http.Cookie;

/**
 * Utility class for managing the quick_start user cookie that remembers the signed-in user.
 * @author Keith Donald
 */
final class UserCookieGenerator {

    private final CookieGenerator userCookieGenerator = new CookieGenerator();

    public UserCookieGenerator() {
        userCookieGenerator.setCookieName("acgoogle_user");
    }

    public void addCookie(String userId, HttpServletResponse response) {
        userCookieGenerator.addCookie(response, userId);
    }

    public void removeCookie(HttpServletResponse response) {
        userCookieGenerator.addCookie(response, "");
    }

    public String readCookieValue(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(userCookieGenerator.getCookieName())) {
                return cookie.getValue();
            }
        }
        return null;
    }

}
