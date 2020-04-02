package cn.gebixiaoba.controller;

import cn.gebixiaoba.bean.Message;
import cn.gebixiaoba.entity.Course;
import cn.gebixiaoba.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2020/3/23.
 */
@Controller
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("list/{term}")
    @ResponseBody
    public List<Course> getCourseList(@PathVariable("term") String term){
        return courseService.getCourseList(term);
    }
    @RequestMapping("term")
    @ResponseBody
    public List<String> getTerm(){
        return courseService.getTerm();
    }
    @RequestMapping("textbook/{courseid}/{isbn}")
    @ResponseBody
    public Message UpdateBook(@PathVariable("courseid") int courseid,@PathVariable("isbn") String isbn){
        return courseService.updateCourse(courseid,isbn);
    }

}
