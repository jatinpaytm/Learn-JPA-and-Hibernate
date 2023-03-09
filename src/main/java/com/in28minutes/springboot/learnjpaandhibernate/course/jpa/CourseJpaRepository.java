package com.in28minutes.springboot.learnjpaandhibernate.course.jpa;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository  // this is marked for the database accessing fields
@Transactional  // when ever executing query with JPA should have @Transactional
public class CourseJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // I am assuming :
    // As there is only 1 table at this point of time , so it knows where to insert
    // the row in the table
    public void insert(Course course) {
        entityManager.merge(course);
    }

    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}
