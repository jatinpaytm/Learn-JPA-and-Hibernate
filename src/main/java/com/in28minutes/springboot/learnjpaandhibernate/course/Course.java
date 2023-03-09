package com.in28minutes.springboot.learnjpaandhibernate.course;

/**
 * when we add @entity and @id we are directly
 * mapping course,java to h2 's database
 * see below code
 * All this is done for JPA otherwise we need to write whole code
 * in case of JDBC
 * */

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity  // (name = "table_name") if suppose the database's table name is different we need to write it as
public class Course {

    @Id
    private long id;

    @Column(name = "name")  // if column names are different then we need to mention them explicitly
    private String name;

    @Column(name = "author")
    private String author;

    public Course() {

    }

    public Course(long id, String name, String author) {
        super();
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    // we need to set the setters to set values from h2 database
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
    }

    // constructor
    // getters
    // toString

}
