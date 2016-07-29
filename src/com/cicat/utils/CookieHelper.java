package com.cicat.utils;

import com.cicat.entity.User;
import com.cicat.service.IUserService;

import javax.servlet.http.Cookie;

/**
 * Created by lunagao on 16/7/28.
 */
public class CookieHelper {
    public static User getCookiesUser(Cookie[] cookies, IUserService service) {
        User u = null;
        if (cookies!=null && cookies.length>0) {
            for (Cookie cookie : cookies) {
                if ("User".equals(cookie.getName())) {
                    String value = cookie.getValue();
                    if (value != null && !value.equals("")) {
                        String[] ss = value.split(CommonString.COOKIE_BREAK_SPLIT_CHAR);
                        if (service.isCheck(ss[0].trim(), ss[1].trim())) {
                            u = service.getUser(ss[0].trim());
                            break;
                        }
                    }
                }
            }
        }
        return u;
    }
}
