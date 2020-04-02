package cn.gebixiaoba.dao;

import cn.gebixiaoba.entity.Teacher;
import org.springframework.stereotype.Repository;

/**
 * TeacherDAO继承基类
 */
@Repository
public interface TeacherDAO extends MyBatisBaseDao<Teacher, String> {
    Teacher findByNameAndPassword(Teacher teacher);
}