package org.zhen.dao;

import org.springframework.stereotype.Repository;
import org.zhen.model.Enrolled;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EnrolledDao {
    private List<Enrolled> enrolledList;

    public EnrolledDao() {
        enrolledList = new ArrayList<>();
        Enrolled enrolled1 = new Enrolled("100","100");
        Enrolled enrolled2 = new Enrolled("101","100");
        Enrolled enrolled3 = new Enrolled("102","102");
        Enrolled enrolled4 = new Enrolled("103","102");
        enrolledList.add(enrolled1); enrolledList.add(enrolled2); enrolledList.add(enrolled3);
        enrolledList.add(enrolled4);

    }
    public List<Enrolled> getEnrolledList() {
        return enrolledList;
    }
    public List<Enrolled> getEnrolledByUserId(String userId) {
        return enrolledList.stream().filter(enrolled -> enrolled.getUserId().equals(userId)).collect(Collectors.toList());
    }
}
