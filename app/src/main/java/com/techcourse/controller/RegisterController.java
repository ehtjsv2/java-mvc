package com.techcourse.controller;

import com.interface21.context.stereotype.Controller;
import com.interface21.web.bind.annotation.RequestMapping;
import com.interface21.web.bind.annotation.RequestMethod;
import com.interface21.webmvc.servlet.ModelAndView;
import com.interface21.webmvc.servlet.view.JspView;
import com.techcourse.domain.User;
import com.techcourse.repository.InMemoryUserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class RegisterController {

//    @Override
//    public String execute(final HttpServletRequest req, final HttpServletResponse res) {
//        final var user = new User(2,
//                req.getParameter("account"),
//                req.getParameter("password"),
//                req.getParameter("email"));
//        InMemoryUserRepository.save(user);
//
//        return "redirect:/index.jsp";
//    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest req, HttpServletResponse res) {
        InMemoryUserRepository.save(
                new User(
                        2,
                        req.getParameter("account"),
                        req.getParameter("password"),
                        req.getParameter("email")
                )
        );
        return new ModelAndView(new JspView("redirect:/index.jsp"));
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView show(HttpServletRequest req, HttpServletResponse res) {
        return new ModelAndView(new JspView("register.jsp"));
    }

}
