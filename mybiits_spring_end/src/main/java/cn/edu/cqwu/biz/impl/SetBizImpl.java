package cn.edu.cqwu.biz.impl;

import cn.edu.cqwu.biz.SetBiz;
import cn.edu.cqwu.mapper.SetMapper;
import cn.edu.cqwu.pojo.Book;
import cn.edu.cqwu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetBizImpl implements SetBiz {
    @Autowired
    private SetMapper setMapper;

//    注册
    @Override
    public int insertUser(User user) {
        return setMapper.insertUser(user);
    }

//    登录
    @Override
    public User queryUser(String username,String password) {
        try {
            User user=setMapper.queryUser(username,password);

            return user;
        }catch (Exception e){
            return null;
        }
    }

//    查询全部图书
    @Override
    public List<Book> findAllBook() {
        return setMapper.findAllBook();
    }
//    插入图书
    @Override
    public int insertBook(Book book) {
        return setMapper.insertBook(book);
    }
//    删除图书
    @Override
    public int deleteBook(int id) {
        return setMapper.deleteBook(id);
    }
//    修改图书
    @Override
    public int updateBook(Book book) {
        return setMapper.updateBook(book);
    }

    @Override
    public Book selectBook(String bookname) {
        return setMapper.selectBook(bookname);
    }

}
