package cn.edu.cqwu.controller;

import cn.edu.cqwu.pojo.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;


@Controller
public class SetController {
//    文件上传
//    单文件上传
//    MultipartFile实现以表单的形式进行文件上传功能。
    @RequestMapping(value = "/test10",method = RequestMethod.POST)
        public String test10(MultipartFile file1,HttpServletRequest request) throws IOException {
        System.out.println(file1);
//        存文件，配置文件上传解析器CommonsMultipartResolver
//        文件夹路径Req.getRealPath()
        System.out.println(request.getRealPath("/setfile"));
//        文件名字.getOriginalFilename
        System.out.println(request.getRealPath("/setfile")+"\\"+file1.getOriginalFilename());
//        transferto将上传文件添加到文件夹
        file1.transferTo(new File(request.getRealPath("/setfile")+"\\"+file1.getOriginalFilename()));
        return "index";
    }
//    多文件上传
    @RequestMapping(value = "/test11",method = RequestMethod.POST)
    public String test11(MultipartFile[] file1,HttpServletRequest request) throws IOException {
        for (MultipartFile file : file1) {
            System.out.println(request.getRealPath("/setfile")+"\\"+file.getOriginalFilename());
            file.transferTo(new File(request.getRealPath("/setfile")+"\\"+file.getOriginalFilename()));
        }
        return "index";
    }
    @RequestMapping(value = "/setfile",method = RequestMethod.GET)
    public String SetFile(){
        return "ajax";
    }



//    回写数据

//    传统方法
    @RequestMapping(value = "/test0",method = RequestMethod.GET)
    @ResponseBody
    public String test0(HttpServletResponse response) throws IOException {
        response.getWriter().println("responsea");
        return "index";
    }

//    produces指定数据类型，与@ResponseBody搭配使用
    @RequestMapping(value = "/test4",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")//纯文本
    @ResponseBody//将方法的返回值以特定的格式写入到response的body区域，进而将数据返回给客户端
    public String test4(){
        return "直接回写，响应内容类型纯文本";
    }

    @RequestMapping(value = "/test5",method = RequestMethod.GET,produces = "text/html;charset=utf-8")//纯文本
    @ResponseBody//将方法的返回值以特定的格式写入到response的body区域，进而将数据返回给客户端
    public String test5(){
        return "<h2>直接回写，响应内容类型html类型，解析</h2>";
    }

//    回写json
    //自动转换
    @RequestMapping(value = "/test6",method = RequestMethod.GET)//纯文本
    @ResponseBody//将方法的返回值以特定的格式写入到response的body区域，进而将数据返回给客户端
    public Student test6(){
        Student student = new Student();
        student.setSid(1);
        student.setName("suerting");
        student.setSno("115");
        student.setBanji(1);
        return student;

        //需要添加转换器，但可用mvc:annotation-driven替换，去掉produces自动转化
    }

//    手动转换
    @RequestMapping(value = "/test7",method = RequestMethod.GET,produces = "text/palin;charset=utf-8")//纯文本
    @ResponseBody//将方法的返回值以特定的格式写入到response的body区域，进而将数据返回给客户端
    public String test7() throws JsonProcessingException {
        Student student = new Student();
        student.setSid(1);
        student.setName("suerting");
        student.setSno("115");
        student.setBanji(1);
        return new ObjectMapper().writeValueAsString(student);
    }


//        ajax
    @RequestMapping(value = "/test8",method = RequestMethod.POST,produces = "text/html;charset=utf-8")//纯文本
    @ResponseBody//将方法的返回值以特定的格式写入到response的body区域，进而将数据返回给客户端
    public String test8() throws JsonProcessingException {
        Student student = new Student();
        student.setSid(1);
        student.setName("suerting");
        student.setSno("115");
        student.setBanji(1);
        return new ObjectMapper().writeValueAsString(student);
    }

    @RequestMapping(value = "/test9",method = RequestMethod.POST)//纯文本
    @ResponseBody//将方法的返回值以特定的格式写入到response的body区域，进而将数据返回给客户端
    public Student test9() throws JsonProcessingException {
        Student student = new Student();
        student.setSid(1);
        student.setName("suerting");
        student.setSno("115");
        student.setBanji(1);
        return student;
    }
    @RequestMapping(value = "/ajax",method = RequestMethod.GET)
    public String doAjax(){
        return "ajax";
    }




    //以下为页面转发S
    @RequestMapping(value = "/test3",method = RequestMethod.GET)
    public String test3(HttpServletRequest request){
        request.setAttribute("name","request");
        request.setAttribute("sno","setAttribute");
        return "index";
    }

    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    public String test2(Model model){
//        model是接口，不能new
        model.addAttribute("name","model");
        model.addAttribute("sno","string");
        return "index";
    }

    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    public ModelAndView test1(ModelAndView modelAndView){
//        Model是封装数据，view是视图
        //将对象使用参数放进去
//        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject ("name","suerting");
        modelAndView.addObject("sno","115");
        //逻辑视图的名字，返回modelAndView，在该页面取数据
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
