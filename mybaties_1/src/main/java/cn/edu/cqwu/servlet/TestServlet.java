package cn.edu.cqwu.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestServlet {
    @GetMapping("/a")
    public String test() {
        return "测试成功！";
    }
}
