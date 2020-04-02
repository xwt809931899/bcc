package cn.gebixiaoba.dao;

import cn.gebixiaoba.entity.Selectcourse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * SelectcourseDAO继承基类
 */
@Repository
public interface SelectcourseDAO extends MyBatisBaseDao<Selectcourse, Selectcourse> {
    int updateSelectCourse(@Param("courseid")int courseid,@Param("stuid") String stuid);
}