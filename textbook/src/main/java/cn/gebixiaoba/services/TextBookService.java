package cn.gebixiaoba.services;

import cn.gebixiaoba.bean.Message;
import cn.gebixiaoba.entity.Textbook;

/**
 * Created by Administrator on 2020/3/24.
 */
public interface TextBookService {
    Textbook getTextbook(String ISBN);

    Message insertBook(Textbook textbook);

    Message updateBook(Textbook textbook);

    Message reduceBook(Textbook textbook);
}
