package com.stzhu.bean;

import java.math.BigDecimal;

public class Book {
    private int id;
    private String name;
    private String author;
    private BigDecimal price;
    private int sales;
    private int stock;
    private String imgPath = "static/img/default.jpg"; // 如果jsp界面中没有name为imgPath的标签,则不会调用setImgPath()方法

    public Book() {
    }

    public Book(String name, String author, BigDecimal price, int sales, int stock, String imgPath) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        if ((imgPath != null) && (!"".equals(imgPath))) {
            this.imgPath = imgPath;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        if ((imgPath != null) && (!"".equals(imgPath))) {
            this.imgPath = imgPath;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", stock=" + stock +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
