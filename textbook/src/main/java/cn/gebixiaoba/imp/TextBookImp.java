package cn.gebixiaoba.imp;

import cn.gebixiaoba.bean.Message;
import cn.gebixiaoba.dao.CourseDAO;
import cn.gebixiaoba.dao.TextbookDAO;
import cn.gebixiaoba.entity.Textbook;
import cn.gebixiaoba.services.TextBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2020/3/24.
 */
@Service
public class TextBookImp implements TextBookService {
    @Autowired
    private TextbookDAO textbookDAO;
    @Autowired
    private CourseDAO courseDAO;

    @Override
    public Textbook getTextbook(String ISBN) {
        return textbookDAO.findByISBN(ISBN);
    }

    @Override
    public Message insertBook(Textbook textbook) {
        Message message = new Message();
        Textbook textbook1 = textbookDAO.selectByPrimaryKey(textbook.getIsbn());
       if( textbook1 != null){
           message.setCode(1);
           message.setMessage("添加成功");
       }else {
           if (textbookDAO.insertSelective(textbook) > 0) {
               message.setCode(1);
               message.setMessage("添加成功");
           } else {
               message.setCode(-1);
               message.setMessage("添加失败");
           }
       }
        return message;
    }

    @Override
    public Message updateBook(Textbook textbook) {

        Textbook textbook1 = textbookDAO.findByISBN(textbook.getIsbn());
        int total = textbook.getTotal()+textbook1.getTotal();
        textbook1.setTotal(total);
        textbook1.setPrice(textbook.getPrice());

        Message message = new Message();

        if(textbookDAO.updateTextbook(textbook1)>0){
            message.setCode(1);
            message.setMessage("操作成功");
        }else {
            message.setCode(-1);
            message.setMessage("操作失败");
        }

        return message;
    }

    @Override
    public Message reduceBook(Textbook textbook) {
        Message message = new Message();
        Textbook textbook1 = textbookDAO.findByISBN(textbook.getIsbn());
        int total = textbook1.getTotal()-textbook.getTotal();
        if(total<0){
            message.setCode(-1);
            message.setMessage("库存不足");
        }else {
            textbook1.setTotal(total);

            if(textbookDAO.updateTextbook(textbook1)>0){
                message.setCode(1);
                message.setMessage("出库成功");
            }else {
                message.setCode(-1);
                message.setMessage("操作失败");
            }
        }
        return message;
    }

}
