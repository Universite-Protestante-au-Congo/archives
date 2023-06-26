package com.stage.upc.randy.pululu.restController;

import com.stage.upc.randy.pululu.models.Course;
import com.stage.upc.randy.pululu.services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {
    @Autowired
    CourseServices courseServices;

    @RequestMapping(method =  RequestMethod.GET)
    public List<Course> getAllCourses(){
        return courseServices.getAllCourses();
    }

    @RequestMapping(value="/{id}",method =  RequestMethod.GET)
    public Course getCourseById(@PathVariable("id") Long id){return courseServices.getCourseById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Course createCourse(@RequestBody Course course) {
        return courseServices.saveCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Course updateCourse(@RequestBody Course course) {
        return courseServices.updateCourse(course);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable("id") Long id) {
        courseServices.deleteCourseById(id);
    }
}
