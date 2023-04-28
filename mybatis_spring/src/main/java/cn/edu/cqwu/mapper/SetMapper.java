package cn.edu.cqwu.mapper;

import cn.edu.cqwu.pojo.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SetMapper {
    @Select("select id,bookname,author,price,status from book")
    List<Book> findAllBook();

    @Insert("insert into book(bookname,author,price,status) values(#{bookname},#{author},#{price},#{status})")
    int insertBook(Book book);

    @Delete("delete from book where id=#{id}")
    int deleteBook(int id);

    @Update("update book set bookname=#{bookname},author=#{author},price=#{price},status=#{status} where id=#{id}")
    int updateBook(Book book);
}
