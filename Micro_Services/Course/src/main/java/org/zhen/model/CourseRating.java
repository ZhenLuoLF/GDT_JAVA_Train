package org.zhen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRating {
    private String ratingId;
    private String courseId;
    private int rating;
    private String comment;
}
