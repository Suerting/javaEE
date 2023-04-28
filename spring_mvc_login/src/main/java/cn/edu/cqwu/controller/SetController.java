package cn.edu.cqwu.controller;

import cn.edu.cqwu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SetController {

    //静态List<User>集合，用来代替数据库来保存注册的用户信息;
    private static List<User> userList;
    //UserController类的构造器，初始化List<User>集合
    public SetController() {
        super();
        userList=new ArrayList<User>();
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String registerForm(){
        return "register";
    }

//    注册界面
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestParam("username") String username,@RequestParam("password") String password){
//        创建user对象
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
//        将数据存到集合中
        userList.add(user);
//        跳转到登录页面
        return "login";

    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password, ModelAndView modelAndView){
        for (User user : userList) {
            if (user.getUsername().equals(username)&&user.getPassword().equals(password)){
                modelAndView.addObject("username",username);
                modelAndView.addObject("password",password);
                modelAndView.setViewName("index");
                return modelAndView;
            }else {
                modelAndView.setViewName("login");
                return modelAndView;
            }
        }
       return modelAndView;
    }


}
