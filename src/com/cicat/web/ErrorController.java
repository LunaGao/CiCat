package com.cicat.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lunagao on 16/8/19.
 */

@Controller
public class ErrorController {

    @RequestMapping(value = "/dberror", method = RequestMethod.GET)
    public String showLoginView(HttpServletRequest request) {
        return "dberror";
    }

}
