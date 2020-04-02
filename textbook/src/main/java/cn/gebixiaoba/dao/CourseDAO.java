package cn.gebixiaoba.dao;

import cn.gebixiaoba.entity.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CourseDAO继承基类
 */
@Repository
public interface CourseDAO extends MyBatisBaseDao<Course, Integer> {
    List<Course> findByTeacherId(@Param("teacher") String teacher,@Param("term") String term);
    List<String> getTerm();
}