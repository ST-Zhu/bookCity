package com.stzhu.dao;

import com.stzhu.bean.Book;
import com.stzhu.bean.Page;

import java.util.List;

public interface BookDao {
    /**
     * 修改图书信息
     * @param id
     * @param book
     * @return 影响的条数
     */
    public int updateById(int id, Book book);

    /**
     * 删除图书
     * @param id
     * @return 影响的条数
     */
    public int deleteById(int id);

    /**
     * 添加图书
     * @param book
     * @return 影响的条数
     */
    public int insertBook(Book book);

    /**
     * 根据ID查询图书信息
     * @param id
     * @return
     */
    public Book selectById(int id);

    /**
     * 查询图书列表信息
     * @return 图书列表
     */
    public List<Book> selectBookList();

    /**
     * 查询图书总数
     * @return
     */
    public int pageTotalCount();

    /**
     * 查询指定页的图书信息
     * @param page
     * @return
     */
    public List<Book> pageItem(Page page);

    /**
     * 通过价格查询图书总数
     * @return
     * @param min
     * @param max
     */
    public int pageTotalCountByPrice(int min, int max);

    /**
     * 通过价格查询图书信息
     * @param page
     * @return
     */
    List<Book> pageItemByPrice(Page page,int min, int max);
}
