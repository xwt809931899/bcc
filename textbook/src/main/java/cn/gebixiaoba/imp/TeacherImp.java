package cn.gebixiaoba.imp;

import cn.gebixiaoba.dao.TeacherDAO;
import cn.gebixiaoba.entity.Teacher;
import cn.gebixiaoba.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2020/3/24.
 */
@Service
public class TeacherImp implements TeacherService {
    @Autowired
    private TeacherDAO teacherDAO;
    @Autowired
    HttpSession session;
    @Override
    public Teacher checkout(Teacher teacher) {

       Teacher teacher1 = teacherDAO.findByNameAndPassword(teacher);
        if(teacher1 != null){
            teacher1.setPassword(session.getId());
            session.setAttribute("teacher",teacher1);
        }
        return teacher1;
    }
}
