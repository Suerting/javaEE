import cn.edu.cqwu.biz.BookBiz;

import cn.edu.cqwu.pojo.Book;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class BookTest {
    @Autowired
    private BookBiz bookBiz;
    @Test
    public void findallbook(){
//        Page<Book> page =new PageHelper.startPage(2,2);
        Page<Book> page=PageHelper.startPage(2,2);
        System.out.println(page);
        System.out.println(bookBiz.findAllBook());
        System.out.println(page);
    }

}
