package cn.gebixiaoba.dao;

import cn.gebixiaoba.entity.Textbook;
import org.springframework.stereotype.Repository;

/**
 * TextbookDAO继承基类
 */
@Repository
public interface TextbookDAO extends MyBatisBaseDao<Textbook, String> {
    Textbook findByISBN(String ISBN);
    int updateTextbook(Textbook textbook);
}