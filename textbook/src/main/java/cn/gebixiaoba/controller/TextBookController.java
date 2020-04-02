package cn.gebixiaoba.controller;

import cn.gebixiaoba.bean.Message;
import cn.gebixiaoba.entity.Textbook;
import cn.gebixiaoba.services.TextBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2020/3/24.
 */
@Controller
@RequestMapping("textbook")
public class TextBookController {
    @Autowired
    private TextBookService textBookService;

    @RequestMapping("isbn/{isbn}")
    @ResponseBody
    public Textbook getTextbook(@PathVariable("isbn")String isbn){
        return textBookService.getTextbook(isbn);
    }
    @RequestMapping("insert")
    @ResponseBody
    public Message insertBook(Textbook textbook){
        System.out.println(textbook.toString());
        return  textBookService.insertBook(textbook);
    }

    @RequestMapping("update")
    @ResponseBody
    public Message updateBook(Textbook textbook){

        System.out.println(textbook.toString());
        return  textBookService.updateBook(textbook);
    }

    @RequestMapping("reduce")
    @ResponseBody
    public Message reduceBook(Textbook textbook){

        System.out.println(textbook.toString());
        return  textBookService.reduceBook(textbook);
    }

}
