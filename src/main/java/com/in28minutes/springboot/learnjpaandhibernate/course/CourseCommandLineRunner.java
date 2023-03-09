package com.in28minutes.springboot.learnjpaandhibernate.course;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import com.in28minutes.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired   // done for jdbc
//    private CourseJdbcRepository repository;

//    @Autowired  // done for JPA
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        // for JDBC and JPA
        //repository.insert(new Course(1, "Learn AWS NOW!", "in28minutes"));
        //repository.insert(new Course(2, "Learn Azure Jpa!", "in28minutes"));
        //repository.insert(new Course(3, "Learn DevOps NOW!", "in28minutes"));

        repository.save(new Course(1, "Learn AWS Jpa!", "in28minutes"));
        repository.save(new Course(2, "Learn Azure Jpa!", "in28minutes"));
        repository.save(new Course(3, "Learn DevOps Jpa!", "in28minutes"));

        repository.deleteById(1l);  // passing l also because the id is of long dataType

        System.out.println(repository.findById(2l));  // predefined method using Primary key
        System.out.println(repository.findById(3l));

        System.out.println(repository.findAll());
        System.out.println(repository.count());  // gives no of rows in table

        System.out.println(repository.findByAuthor("in28minutes"));  // Custom method
        System.out.println(repository.findByAuthor(""));

        System.out.println(repository.findByName("Learn AWS Jpa!"));  // Custom method
        System.out.println(repository.findByName("Learn DevOps Jpa!"));


    }
}
