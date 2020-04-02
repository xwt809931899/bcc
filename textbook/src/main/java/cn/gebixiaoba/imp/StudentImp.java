package cn.gebixiaoba.imp;

import cn.gebixiaoba.dao.StudentDAO;
import cn.gebixiaoba.entity.OrderedBook;
import cn.gebixiaoba.entity.Student;
import cn.gebixiaoba.entity.StudentCourseOrderBook;
import cn.gebixiaoba.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2020/3/25.
 */
@Service
public class StudentImp implements StudentService {
    @Autowired
    private StudentDAO studentDAO;
    @Autowired
    HttpSession session;
    @Override
    public Student checkout(Student student) {
        Student student1 = studentDAO.findByNameAndPassword(student);
        if(student1 != null) {
            student1.setPassword(session.getId());
            session.setAttribute("student", student1);
        }
        return student1;
    }

    @Override
    public List<OrderedBook> findStudentOrderedBook() {
        Student student = (Student) session.getAttribute("student");
        if(student != null){
            return studentDAO.findStudentOrderedBook(student.getStuid());
        }else {
            return null;
        }
    }

    @Override
    public List<StudentCourseOrderBook> findStudentNotOrderedBook() {
        Student student = (Student) session.getAttribute("student");
        if(student != null){
            return studentDAO.findStudentNotOrderedBook(student.getStuid());
        }else {
            return null;
        }
    }
}
