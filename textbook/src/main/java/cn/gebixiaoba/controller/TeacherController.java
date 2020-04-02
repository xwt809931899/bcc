package cn.gebixiaoba.controller;

import cn.gebixiaoba.entity.Teacher;
import cn.gebixiaoba.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2020/3/24.
 */
@Controller
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @RequestMapping("login")
    @ResponseBody
    public Teacher login(Teacher teacher){
        return teacherService.checkout(teacher);
    }
}
