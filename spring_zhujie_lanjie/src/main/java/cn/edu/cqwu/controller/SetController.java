package cn.edu.cqwu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SetController {
    @RequestMapping(value = "a",method = RequestMethod.GET)
    public String a(){
        System.out.println("wefd");
        return "fgsd";
    }
    @RequestMapping(value = "b",method = RequestMethod.GET)
    public String b(){
        System.out.println("regsf");
        return "sergf";
    }
}
