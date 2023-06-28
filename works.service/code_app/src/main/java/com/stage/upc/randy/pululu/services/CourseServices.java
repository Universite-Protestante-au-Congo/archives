package com.stage.upc.randy.pululu.services;

import com.stage.upc.randy.pululu.models.Course;

import java.util.List;

public interface CourseServices {
    Course saveCourse (Course c);
    Course updateCourse(Course c);
    void deleteCourse(Course c);
    void deleteCourseById(Long id);
    Course getCourseById(Long id);
    List<Course> getAllCourses();
}
