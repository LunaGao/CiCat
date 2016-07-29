package com.cicat.web;

import com.cicat.entity.User;
import com.cicat.service.IUserService;
import com.cicat.utils.CookieHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lunagao on 16/7/25.
 */

@Controller
public class LoginController {

    @Resource
    IUserService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showLoginView(HttpServletRequest request) {
        User u = CookieHelper.getCookiesUser(request.getCookies(), service);
        if (u != null) {
            return "redirect:/dashboard";
        }
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(ModelMap model, @RequestParam String name, @RequestParam String password, HttpServletResponse response) {
        Boolean isCheck = service.isCheck(name, password);
        if (isCheck) {
            User user = service.getUser(name);
            Cookie cookie = new Cookie("User",user.toStringForCookie());
            cookie.setMaxAge(60*60*24*7);
            response.addCookie(cookie);
            return "redirect:/dashboard";
        } else {
            model.addAttribute("name", name);
            model.addAttribute("error", "User Name or Password error");
            return "login";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("User".equals(cookie.getName())) {
                    Cookie cookieReplace = new Cookie("User",null);
                    cookieReplace.setMaxAge(60*60*24*7);
                    response.addCookie(cookieReplace);
                    break;
                }
            }
        }
        return "redirect:/dashboard";
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(ModelMap model) {
        return "dashboard";
    }
}
