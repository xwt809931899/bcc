package cn.gebixiaoba.dao;

import cn.gebixiaoba.entity.OrderedBook;
import cn.gebixiaoba.entity.Student;
import cn.gebixiaoba.entity.StudentCourseOrderBook;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * StudentDAO继承基类
 */
@Repository
public interface StudentDAO extends MyBatisBaseDao<Student, String> {
    Student findByNameAndPassword(Student student);
    List<OrderedBook> findStudentOrderedBook(String stuid);
    List<StudentCourseOrderBook> findStudentNotOrderedBook(String stuid);
}