package com.stage.upc.randy.pululu.services.implementation;

import com.stage.upc.randy.pululu.models.Course;
import com.stage.upc.randy.pululu.repository.CourseRepository;
import com.stage.upc.randy.pululu.services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServicesImp implements CourseServices {
    @Autowired
    CourseRepository courseRepository;
    @Override
    public Course saveCourse(Course c) {
        return courseRepository.save(c);
    }

    @Override
    public Course updateCourse(Course c) {
        return courseRepository.save(c);
    }

    @Override
    public void deleteCourse(Course c) {
        courseRepository.delete(c);
    }

    @Override
    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
