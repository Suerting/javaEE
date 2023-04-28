package cn.edu.cqwu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int id;
    private String bookname;
    private String author;
    private String price;
    private int status;

    public Book(String bookname, String author, String price, int status) {
        this.bookname=bookname;
        this.author=author;
        this.price=price;
        this.status=status;
    }
}
