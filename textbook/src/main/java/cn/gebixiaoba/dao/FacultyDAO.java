package cn.gebixiaoba.dao;

import cn.gebixiaoba.entity.Faculty;
import org.springframework.stereotype.Repository;

/**
 * FacultyDAO继承基类
 */
@Repository
public interface FacultyDAO extends MyBatisBaseDao<Faculty, Integer> {
}