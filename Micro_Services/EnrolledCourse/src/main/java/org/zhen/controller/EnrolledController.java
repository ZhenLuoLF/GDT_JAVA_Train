package org.zhen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhen.dao.EnrolledDao;
import org.zhen.model.Enrolled;

import java.util.List;

@RestController
@RequestMapping("/Enrolled")
public class EnrolledController {
    @Autowired
    EnrolledDao enrolledDao;

    @GetMapping("/health")
    public String health(){
        return "server is  health";
    }
    @GetMapping("/getEnrolled/{userId}")
    public List<Enrolled> getEnrolled(@PathVariable("userId") String userId){
        return enrolledDao.getEnrolledByUserId(userId);
    }
}
