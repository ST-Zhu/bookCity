package com.stzhu.service;

import com.stzhu.bean.Book;
import com.stzhu.bean.Page;

import java.util.List;

public interface BookService {
    /**
     * 修改图书信息
     * @param id
     * @param book
     * @return  true or false
     */
    public boolean reviseBook(int id, Book book);

    /**
     * 删除图书
     * @param id
     * @return  true or false
     */
    public boolean deleteBook(int id);

    /**
     * 添加图书
     * @param book
     * @return  true or false
     */
    public boolean addBook(Book book);

    /**
     * 查询图书列表
     * @return 查询列表
     */
    public List<Book> select();

    /**
     * 通过id查找Book类型对象
     * @param id
     * @return
     */
    public Book selectById(int id);

    /**
     * 分页查询
     * @param page
     */
    public void page(Page page);

    /**
     * 返回最后一页的页码
     * @return
     */
    public int pageLast();

    /**
     * 通过价格区间搜索图书
     * @param page
     * @param min
     * @param max
     */
    void pageByPrice(Page page, int min, int max);
}
