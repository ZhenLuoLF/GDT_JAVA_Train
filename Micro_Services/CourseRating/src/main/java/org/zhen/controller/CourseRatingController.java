package org.zhen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhen.dao.CourseRatingDAO;
import org.zhen.model.CourseRating;

import java.util.List;

@RestController
@RequestMapping("/CourseRating")
public class CourseRatingController {
    @Autowired
    CourseRatingDAO courseRatingDAO;

    @GetMapping("/health")
    public String health(){
        return "server is  health";
    }

    @GetMapping("/getRating/{ratingId}")
    public CourseRating getRating(@PathVariable("ratingId") String ratingId){
        return courseRatingDAO.getCourseRatingById(ratingId).orElse(null);
    }
    @GetMapping("/getCourseRating/{courseId}")
    public List<CourseRating> getCourseRating(@PathVariable("courseId") String courseId){
        return courseRatingDAO.getCourseRatingByCourseId(courseId);
    }

    @GetMapping("/allRating")
    public List<CourseRating> getAllRating(){
        return courseRatingDAO.getCourseRatingList();
    }
}
