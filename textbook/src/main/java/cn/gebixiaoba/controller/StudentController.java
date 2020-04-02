package cn.gebixiaoba.controller;

import cn.gebixiaoba.entity.OrderedBook;
import cn.gebixiaoba.entity.Student;
import cn.gebixiaoba.entity.StudentCourseOrderBook;
import cn.gebixiaoba.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2020/3/25.
 */
@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("login")
    @ResponseBody
    public Student login(Student student){
        System.out.println(student);
        return studentService.checkout(student);
    }

    @RequestMapping("orderedbook")
    @ResponseBody
    public List<OrderedBook> findOrderedBook(){
        return studentService.findStudentOrderedBook();
    }

    @RequestMapping("notorderedbook")
    @ResponseBody
    public List<StudentCourseOrderBook> findNotOrderedBook(){
        return studentService.findStudentNotOrderedBook();
    }
}
