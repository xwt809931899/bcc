package cn.gebixiaoba.controller;

import cn.gebixiaoba.bean.Message;
import cn.gebixiaoba.services.SelectCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2020/3/26.
 */
@Controller
@RequestMapping("selectcourse")
public class SelectCourseController {
    @Autowired
    private SelectCourseService selectCourseService;
    @RequestMapping("update/{courseid}")
    @ResponseBody
    public Message updateSelectBook(@PathVariable("courseid") int courseid){
        return  selectCourseService.updateSelectCourse(courseid);
    }
}
