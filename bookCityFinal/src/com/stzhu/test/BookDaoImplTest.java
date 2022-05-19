package com.stzhu.test;

import com.stzhu.bean.Book;
import com.stzhu.dao.BookDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;

public class BookDaoImplTest {
    BookDaoImpl bdi = new BookDaoImpl();

    @Test
    public void updateBook() {
        Book book = new Book("三体II", "刘慈欣", new BigDecimal(60), 10000, 10000, null);
        System.out.println(bdi.updateById(22, book));
    }

    @Test
    public void deleteBook() {
        System.out.println(bdi.deleteById(22));
    }

    @Test
    public void insertBook() {
        Book book = new Book("三体I", "刘慈欣", new BigDecimal(50), 10000, 10000, null);
        System.out.println(bdi.insertBook(book));
    }

    @Test
    public void select() {
        System.out.println(bdi.selectById(20));
    }

    @Test
    public void selectBook() {
        System.out.println(bdi.selectBookList());
    }
}