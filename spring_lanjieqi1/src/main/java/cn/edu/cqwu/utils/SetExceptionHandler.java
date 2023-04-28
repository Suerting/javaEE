package cn.edu.cqwu.utils;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView=new ModelAndView();
//        跳转的页面
        modelAndView.setViewName("error");
        modelAndView.addObject("e",ex);
        return modelAndView;
    }
}
