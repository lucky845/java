package com.spring5.entity;

/**
 * @author lichuang
 * @create 2021-08-25 17:45
 * @project_name spring5
 */
public class Book {

    private String id;
    private String name;
    private String status;

    public Book(String id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Book() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
