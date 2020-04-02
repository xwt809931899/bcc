package cn.gebixiaoba.services;

import cn.gebixiaoba.bean.Message;
import cn.gebixiaoba.entity.Course;

import java.util.List;

/**
 * Created by Administrator on 2020/3/23.
 */
public interface CourseService {
    List<Course> getCourseList(String term);
    List<String> getTerm();
    Message updateCourse(int courseid,String ISBN);
}

