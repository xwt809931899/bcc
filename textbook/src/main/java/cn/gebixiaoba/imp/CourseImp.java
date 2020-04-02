package cn.gebixiaoba.imp;

import cn.gebixiaoba.bean.Message;
import cn.gebixiaoba.dao.CourseDAO;
import cn.gebixiaoba.entity.Course;
import cn.gebixiaoba.entity.Teacher;
import cn.gebixiaoba.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2020/3/23.
 */
@Service
public class CourseImp implements CourseService {
    @Autowired
    private CourseDAO courseDAO;
    @Autowired
    HttpSession session;
    @Override
    public List<Course> getCourseList(String term) {
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        if(teacher != null){
            return courseDAO.findByTeacherId(teacher.getTeacherid(),term);
        }else{
            return null;
        }
    }
    @Override
    public List<String> getTerm(){
        return courseDAO.getTerm();
    }

    @Override
    public Message updateCourse(int courseid,String ISBN) {
        Message message = new Message();
        Course course = courseDAO.selectByPrimaryKey(courseid);
        course.setTextbook(ISBN);
        if (courseDAO.updateByPrimaryKey(course) > 0) {
            message.setCode(1);
            message.setMessage("添加成功");
        } else {
            message.setCode(-1);
            message.setMessage("添加失败");
        }
        return message;
    }
}
