package org.zhen.controller;

import org.apache.coyote.Response;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.zhen.model.CourseRating;
import org.zhen.model.Enrolled;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/Health")
    public String health() {
        return "Server is health";
    }

    @GetMapping("/GetCourse/{userId}")
    public List<List<CourseRating>> getCourseList(@PathVariable("userId") String userId) {
        String url = "http://EnrolledCourse/Enrolled/getEnrolled/" + userId;
        ResponseEntity<List<Enrolled>> enrolledResponse = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Enrolled>>() {}
        );

        List<Enrolled> enrolledList = enrolledResponse.getBody();
        List<CourseRating> courseRatingList = null;
        List<List<CourseRating>> retList = new ArrayList<>();
        ResponseEntity<List<CourseRating>> courseRatingResponse = null;
        for (Enrolled enrolled : enrolledList) {
            url = "http://CourseRating/CourseRating/getCourseRating/" + enrolled.getCourseId();
            courseRatingResponse = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<CourseRating>>() {}
            );
            courseRatingList = courseRatingResponse.getBody();
            retList.add(courseRatingList);
        }
        return retList;
    }
}
