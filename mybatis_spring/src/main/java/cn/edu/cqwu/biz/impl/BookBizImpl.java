package cn.edu.cqwu.biz.impl;

import cn.edu.cqwu.biz.BookBiz;
import cn.edu.cqwu.mapper.SetMapper;
import cn.edu.cqwu.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookBizImpl implements BookBiz {
    @Autowired
    private SetMapper setMapper;
    @Override
    public List<Book> findAllBook() {
        return setMapper.findAllBook();
    }
    @Override
    public int insertBook(Book book) {
        return setMapper.insertBook(book);
    }
    @Override
    public int deleteBook(int id) {
        return setMapper.deleteBook(id);
    }
    @Override
    public int updateBook(Book book) {
        return setMapper.updateBook(book);
    }
}
