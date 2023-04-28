package cn.edu.cqwu.controller;

import cn.edu.cqwu.biz.SetBiz;
import cn.edu.cqwu.pojo.Book;
import cn.edu.cqwu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@ComponentScan("cn.edu.cqwu")

public class SetController {
    @Autowired
    private SetBiz setBiz;

//    注册
    @RequestMapping(value = "userregister",method = RequestMethod.GET)
    public String userregister(){
        return "register";
    }
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String register(String username,String password){
        User user=new User(username,password);
        int count=setBiz.insertUser(user);
        if (count>0){
            return "redirect:/userlogin";
        }else{
            return "register";
        }
    }

//    登录
    @RequestMapping(value = "userlogin",method = RequestMethod.GET)
    public String userlogin(){
        return "login";
    }
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ModelAndView login(ModelAndView modelAndView, String username, String password, HttpSession session){
        User user=setBiz.queryUser(username,password);
        if(user!=null){
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            modelAndView.setViewName("redirect:/findAllBook");
            return modelAndView;
        }else{
            modelAndView.addObject("msg","登录失败，用户名或密码有误");
//            清空seesion
            session.invalidate();
            return modelAndView;
        }
    }

//    查询全部图书
    @RequestMapping(value = "findAllBook",method = RequestMethod.GET)
    public String findAllBook(Model model){
        List<Book> books=setBiz.findAllBook();
        model.addAttribute("books",books);
        return "allbooklist";
    }

    @RequestMapping(value = "searchbook",method = RequestMethod.POST)
    public String searchbookname(String bookname,Model model){
        Book book=setBiz.selectBook(bookname);
        List<Book> books=new ArrayList<>();
        books.add(book);
        //如果未查到，文字提示
        if(book==null){
            books = setBiz.findAllBook();
            model.addAttribute("error","未查到");
        }
        model.addAttribute("books",books);
        return "allbooklist";
    }

//    插入图书
    @RequestMapping(value = "addbookjump",method = RequestMethod.GET)
    public String addbookjump(){
        return "addbook";
    }
    @RequestMapping(value = "addbooks",method = RequestMethod.POST)
    public String addbooks(String bookname,String author,String price,Integer status){
        Book book=new Book(bookname,author,price,status);
        int count=setBiz.insertBook(book);
        if(count>0){
            return "success";
        }else{
            return "addbook";
        }
    }

//    删除图书
    @RequestMapping(value = "/deletebook",method = RequestMethod.GET)
    public String deletebook(Integer id){
        int count= setBiz.deleteBook(id);
        if(count>0){
            return "success";
        }else{
            return "error";
        }
    }

//    修改图书
    //    获取点击的id，传到jsp
    @RequestMapping(value = "/updatejump",method = RequestMethod.GET)
    public String updatejump(Integer id,Model model){
        model.addAttribute("id",id);
        return "updatebook";
    }
    @RequestMapping(value = "/updatebook",method = RequestMethod.POST)
    public String updatebook(Integer id,String bookname,String author,String price,Integer status,Model model){
        Book books=new Book(id,bookname,author,price,status);
        int count=setBiz.updateBook(books);
        if(count>0){
            model.addAttribute("books",books);
            return "success";
        }else{
            return "error";
        }
    }

}

