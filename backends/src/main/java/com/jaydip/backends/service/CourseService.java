package com.jaydip.backends.service;

import com.jaydip.backends.model.Course;
import com.jaydip.backends.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public List<Course> getActiveCourses() {
        return courseRepository.findByActiveTrue();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course course) {
        Course existing = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        existing.setTitle(course.getTitle());
        existing.setSector(course.getSector());
        existing.setDuration(course.getDuration());
        existing.setDescription(course.getDescription());
        existing.setFee(course.getFee());
        existing.setActive(course.getActive());

        return courseRepository.save(existing);
    }

    public List<String> getAllSectors() {
        return List.of("IT", "Healthcare", "Retail", "Construction", "Automotive", "Hospitality");
    }
}