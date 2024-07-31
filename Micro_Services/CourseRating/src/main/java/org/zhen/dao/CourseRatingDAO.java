package org.zhen.dao;

import org.springframework.stereotype.Repository;
import org.zhen.model.CourseRating;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CourseRatingDAO {
    List<CourseRating> courseRatingList;

    public CourseRatingDAO() {
        courseRatingList = new ArrayList<>();

        CourseRating courseRating1 = new CourseRating("100","100",7,"Good");
        CourseRating courseRating2 = new CourseRating("102","101",3,"Good2");
        CourseRating courseRating3 = new CourseRating("103","102",8,"Good3");
        CourseRating courseRating4 = new CourseRating("104","103",9,"Good4");
        CourseRating courseRating5 = new CourseRating("105","100",5,"Good5");
        CourseRating courseRating6 = new CourseRating("106","101",6,"Good6");
        CourseRating courseRating7 = new CourseRating("107","102",7,"Good7");
        CourseRating courseRating8 = new CourseRating("108","103",8,"Good8");
        courseRatingList.add(courseRating1); courseRatingList.add(courseRating2); courseRatingList.add(courseRating3);
        courseRatingList.add(courseRating4); courseRatingList.add(courseRating5); courseRatingList.add(courseRating6);
        courseRatingList.add(courseRating7); courseRatingList.add(courseRating8);
    }

    public List<CourseRating> getCourseRatingList(){
        return courseRatingList;
    }

    public Optional<CourseRating> getCourseRatingById(String id){
        return courseRatingList.stream().filter(course -> course.getRatingId().equals(id)).findFirst();
    }

    public List<CourseRating> getCourseRatingByCourseId(String courseId){
        return courseRatingList.stream().filter(course -> course.getCourseId().equals(courseId)).collect(Collectors.toList());
    }
}
