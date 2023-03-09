package com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course,Long> {  // <name of table it manages , the datatype of primary key>


    // Custom methods
    // follow the convention
    // findByColumn_name --> column_name first letter should be capital
    List<Course> findByAuthor(String author);
    List<Course> findByName(String name);
}
