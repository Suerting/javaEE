package cn.edu.cqwu.biz;

import cn.edu.cqwu.pojo.Book;
import cn.edu.cqwu.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SetBiz {
//    注册
    int insertUser(User user);
//    登录
    User queryUser(String username,String password);

    //    查找全部
    List<Book> findAllBook();

    //    增加数据
    int insertBook(Book book);

    //    删除数据
    int deleteBook(int id);

    //    更新数据
    int updateBook(Book book);

    Book selectBook(String bookname);
}
