package cn.gebixiaoba.services;

import cn.gebixiaoba.entity.OrderedBook;
import cn.gebixiaoba.entity.Student;
import cn.gebixiaoba.entity.StudentCourseOrderBook;

import java.util.List;

/**
 * Created by Administrator on 2020/3/25.
 */
public interface StudentService {
    Student checkout(Student student);
    List<OrderedBook> findStudentOrderedBook();
    List<StudentCourseOrderBook> findStudentNotOrderedBook();
}
