package com.stzhu.test;

import com.stzhu.bean.Book;
import com.stzhu.bean.Page;
import com.stzhu.service.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceImplTest {
    private BookServiceImpl bsi = new BookServiceImpl();
    @Test
    public void reviseBook() {
        Book book = new Book("三体II", "刘慈欣", new BigDecimal(60), 10000, 10000, null);
        System.out.println(bsi.reviseBook(23, book));
    }

    @Test
    public void deleteBook() {
        System.out.println(bsi.deleteBook(23));
    }

    @Test
    public void addBook() {
        Book book = new Book("三体I", "刘慈欣", new BigDecimal(60), 10000, 10000, null);
        System.out.println(bsi.addBook(book));
    }

    @Test
    public void select() {
        System.out.println(bsi.select());
    }

    @Test
    public void page() {
        Page page = new Page();
        page.setPageNo(2);
        bsi.page(page);
        System.out.println(page);
    }

    @Test
    public void pageByPrice() {
        Page page = new Page();
        page.setPageNo(2);
        bsi.pageByPrice(page, 10, 50);
        System.out.println(page);
    }
}