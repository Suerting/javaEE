package cn.edu.cqwu.mapper;

import cn.edu.cqwu.pojo.Book;
import cn.edu.cqwu.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Repository
@Mapper
public interface SetMapper {
//    注册
    @Insert("insert into user values(#{username},#{password})")
    int insertUser(User user);

//    登录
    @Select("select username,password from user where username=#{username} and password=#{password}")
//    多个查询写@Param注解
    User queryUser(@Param("username") String username, @Param("password") String password);

//    查询全部
    @Select("select id,bookname,author,price,status from book")
    List<Book> findAllBook();
//    添加图书
    @Insert("insert into book(bookname,author,price,status) values(#{bookname},#{author},#{price},#{status})")
    int insertBook(Book book);
//    删除图书
    @Delete("delete from book where id=#{id}")
    int deleteBook(int id);
//    修改图书信息
    @Update("update book set bookname=#{bookname},author=#{author},price=#{price},status=#{status} where id=#{id}")
    int updateBook(Book book);

    @Select("select id,bookname,author,price,status from book where bookname=#{bookname}")
    Book selectBook(String bookname);

}

