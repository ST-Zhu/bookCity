package com.stzhu.service;

import com.stzhu.bean.Book;
import com.stzhu.bean.Page;
import com.stzhu.dao.BookDaoImpl;

import java.util.List;

public class BookServiceImpl implements BookService{
    BookDaoImpl bdi = new BookDaoImpl();
    @Override
    public boolean reviseBook(int id, Book book) {
        int count = bdi.updateById(id, book);
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBook(int id) {
        int count = bdi.deleteById(id);
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addBook(Book book) {
        int count = bdi.insertBook(book);
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Book> select() {
        return bdi.selectBookList();
    }

    @Override
    public Book selectById(int id) {
        return bdi.selectById(id);
    }

    @Override
    public void page(Page page) {
        page.setPageTotalCount(bdi.pageTotalCount());
        int total = page.getPageTotalCount() / page.getPageSize();
        if (page.getPageTotalCount() % page.getPageSize() > 0) {
            total += 1;
        }
        page.setPageTotal(total);
        page.setItem(bdi.pageItem(page));
    }

    @Override
    public int pageLast() {
        Page page =new Page();
        page.setPageTotalCount(bdi.pageTotalCount());
        int total = page.getPageTotalCount() / page.getPageSize();
        if (page.getPageTotalCount() % page.getPageSize() > 0) {
            total += 1;
        }
        return total;
    }

    @Override
    public void pageByPrice(Page page, int min, int max) {
        page.setPageTotalCount(bdi.pageTotalCountByPrice(min, max));
        int total = page.getPageTotalCount() / page.getPageSize();
        if (page.getPageTotalCount() % page.getPageSize() > 0) {
            total += 1;
        }
        page.setPageTotal(total);
        page.setItem(bdi.pageItemByPrice(page, min, max));
    }
}
