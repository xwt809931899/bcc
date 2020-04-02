package cn.gebixiaoba.imp;

import cn.gebixiaoba.bean.Message;
import cn.gebixiaoba.dao.SelectcourseDAO;
import cn.gebixiaoba.entity.Student;
import cn.gebixiaoba.services.SelectCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2020/3/26.
 */
@Service
public class SelectCourseImp implements SelectCourseService {
    @Autowired
    private SelectcourseDAO selectcourseDAO;
    @Autowired
    private HttpSession session;

    @Override
    public Message updateSelectCourse(int courseid) {

        Message message = new Message();

        Student student = (Student) session.getAttribute("student");
        if(student != null){
            if(selectcourseDAO.updateSelectCourse(courseid,student.getStuid())> 0 ){
                message.setCode(1);
                message.setMessage("教材订购成功");
            }else{
                message.setCode(-1);
                message.setMessage("教材订购失败");
            }
        }else {
            message.setCode(-1);
            message.setMessage("订购教材失败");
        }
        return message;
    }
}
