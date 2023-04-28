package cn.edu.cqwu.biz;

import cn.edu.cqwu.pojo.Book;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BookBiz {
//    查找全部
    List<Book> findAllBook();

//    增加数据
    int insertBook(Book book);

//    删除数据
    int deleteBook(int id);

//    更新数据
    int updateBook(Book book);
}
