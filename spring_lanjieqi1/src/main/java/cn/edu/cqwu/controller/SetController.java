package cn.edu.cqwu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class SetController {
//    局部异常处理器
    @ExceptionHandler
    public ModelAndView handleException(Exception ex){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("e",ex);
        return modelAndView;
    }



    @RequestMapping(value = "/setlogin",method = RequestMethod.POST)
    public String setlogin(String username, String password, HttpSession session){
        if ("suerting".equals(username)&&"123456".equals(password)){
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            System.out.println(username);
            return "index";
        }else{
//            清空seesion
            session.invalidate();
            return "login";
        }
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/lanjie2",method = RequestMethod.GET)
    public ModelAndView lanjieqi2(ModelAndView modelAndView){
        modelAndView.addObject("name","局部：HandlerInterceptor");
        modelAndView.setViewName("index");
        System.out.println(3/0);
        System.out.println("lanjie2局部拦截器.....");
        return modelAndView;
    }
    @RequestMapping(value = "/lanjie1",method = RequestMethod.GET)
    public ModelAndView lanjieqi1(ModelAndView modelAndView){
        modelAndView.addObject("name","全局：HandlerInterceptor");
        modelAndView.setViewName("index");
        System.out.println("lanjie1全局拦截器.....");
        return modelAndView;
    }
}
