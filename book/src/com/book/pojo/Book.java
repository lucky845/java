package com.book.pojo;

import java.math.BigDecimal;

/**
 * @author lichuang
 * @create 2021-08-16 18:10
 */
public class Book {

    private Integer id; // 图书编号
    private String name; // 图书名
    private String author; // 作者
    private BigDecimal price; // 单价价格
    private Integer sales; // 销量
    private Integer stock; // 库存
    private String imgPath = "static/img/default.jpg"; // 默认展示图片地址

    public Book() {
    }

    public Book(Integer id, String name, String author, BigDecimal price, Integer sales, Integer stock, String imgpath) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        // 要求给定的图书封面图书路径不能为空
        if(imgPath != null && !"".equals(imgPath)) {
            this.imgPath = imgPath;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        // 要求给定的图书封面图书路径不能为空
        if(imgPath != null && !"".equals(imgPath)) {
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
