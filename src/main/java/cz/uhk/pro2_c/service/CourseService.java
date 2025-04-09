package cz.uhk.pro2_c.service;

import cz.uhk.pro2_c.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    List<Course> getCourses();
    void saveCourse(Course course);
    Course getCourse(long id);
    void deleteCourse(long id);
}
