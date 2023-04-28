package cn.edu.cqwu.controller;

import cn.edu.cqwu.biz.BookBiz;
import cn.edu.cqwu.pojo.Book;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SetController {
    @Autowired
    private BookBiz bookBiz;
    @RequestMapping(value = "/fenye",method = RequestMethod.GET)
    public String fenye(Model model,Integer pageSize,Integer pageNo){
        System.out.println(pageSize+pageNo);
        PageHelper.startPage(pageNo,pageSize);
        List<Book> books=bookBiz.findAllBook();
        model.addAttribute("books",books);
        PageInfo<Book> page=new PageInfo<Book>(books);
        model.addAttribute("pageD",page);
        return "allbooklist";
    }

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public String findAll(Model model){
        List<Book> books=bookBiz.findAllBook();
        model.addAttribute("books",books);
        return "allbooklist";
    }

    @RequestMapping(value = "/addbooks",method = RequestMethod.POST)
    public String addbooks(String bookname,String author,String price,Integer status,Model model){
        Book books=new Book(bookname,author,price,status);
        bookBiz.insertBook(books);
        model.addAttribute("books",books);
        return "success";
    }
    @RequestMapping(value = "/addbookjump",method = RequestMethod.GET)
    public String add(){
        return "addBook";
    }

    @RequestMapping(value = "/deletebook",method = RequestMethod.GET)
    public String deletebook(Integer id){
        int count= bookBiz.deleteBook(id);
        System.out.println(count);
        return "success";
    }

    @RequestMapping(value = "/updatebook",method = RequestMethod.POST)
    public String updatebook(Integer id,String bookname,String author,String price,Integer status,Model model){
        System.out.println(id+bookname+author);
        Book books=new Book(id,bookname,author,price,status);
        System.out.println(books);
        bookBiz.updateBook(books);
        model.addAttribute("books",books);
        return "success";
    }
//    获取点击的id，传到jsp
    @RequestMapping(value = "/updatejump",method = RequestMethod.GET)
    public String updatejump(Integer id,Model model){
        model.addAttribute("id",id);
        System.out.println(id);
        return "updateBook";
    }

}
