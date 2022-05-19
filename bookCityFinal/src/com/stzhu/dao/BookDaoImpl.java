package com.stzhu.dao;

import com.stzhu.bean.Book;
import com.stzhu.bean.Page;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao{
    @Override
    public int updateById(int id, Book book) {
        String sql = "update t_book set name = ?, author = ?, price = ?, sales = ?, stock = ?, imgPath = ? where id = ?";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), id);
    }

    @Override
    public int deleteById(int id) {
        String sql = "delete from t_book where id = ?";
        return update(sql, id);
    }

    @Override
    public int insertBook(Book book) {
        String sql = "insert into t_book(name, author, price, sales, stock, imgPath) values(?, ?, ?, ?, ?, ?)";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public Book selectById(int id) {
        String sql = "select * from t_book where id = ?";
        return select(Book.class, sql, id);
    }


    @Override
    public List<Book> selectBookList() {
        String sql = "select * from t_book";
        return selectList(Book.class, sql);
    }


    @Override
    public int pageTotalCount() {
        String sql = "select count(*) from t_book";
        Number number = (Number)selectSingle(sql);
        return number.intValue();
    }

    @Override
    public List<Book> pageItem(Page page) {
        String sql = "select * from t_book limit ?, ?";
        return selectList(Book.class, sql, (page.getPageNo() - 1) * page.getPageSize(), page.getPageSize());
    }

    @Override
    public int pageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number number = (Number)selectSingle(sql, min, max);
        return number.intValue();
    }

    @Override
    public List<Book> pageItemByPrice(Page page, int min, int max) {
        String sql = "select * from t_book where price between ? and ? order by price asc limit ?, ?";
        return selectList(Book.class, sql, min, max, (page.getPageNo() - 1) * page.getPageSize(), page.getPageSize());
    }
}
