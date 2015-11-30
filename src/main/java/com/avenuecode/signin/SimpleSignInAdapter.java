package com.avenuecode.signin;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by ac-jlima on 11/29/15.
 */
public class SimpleSignInAdapter implements SignInAdapter {

    private final UserCookieGenerator userCookieGenerator = new UserCookieGenerator();

    @Override
    public String signIn(String userId, Connection<?> connection, NativeWebRequest request) {
        userCookieGenerator.addCookie(userId, request.getNativeResponse(HttpServletResponse.class));
        SignInUtils.signin(userId);
        return null;
    }

}
