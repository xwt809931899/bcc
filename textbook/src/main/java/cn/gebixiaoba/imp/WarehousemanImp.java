package cn.gebixiaoba.imp;

import cn.gebixiaoba.bean.Message;
import cn.gebixiaoba.dao.SignatureDAO;
import cn.gebixiaoba.dao.WarehousemanDAO;
import cn.gebixiaoba.entity.Signature;
import cn.gebixiaoba.entity.Warehouseman;
import cn.gebixiaoba.entity.WarehousemanOrderBook;
import cn.gebixiaoba.services.WarehousemanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2020/3/27.
 */
@Service
public class WarehousemanImp implements WarehousemanService {

    @Autowired
    private WarehousemanDAO warehousemanDAO;
    @Autowired
    private SignatureDAO signatureDAO;
    @Autowired
    HttpSession session;

    @Override
   public Warehouseman checkout(Warehouseman warehouseman){

        Warehouseman warehouseman1 = warehousemanDAO.findByNameAndPassword(warehouseman);
        if(warehouseman1 != null){
            warehouseman1.setPassword(session.getId());
            session.setAttribute("warehouseman",warehouseman1);
        }
        return warehouseman1;
    }

    @Override
    public List<WarehousemanOrderBook> findAllOrderBook() {
        return warehousemanDAO.findAllOrderBook();
    }
    @Override
    public Message upload(Signature signature){
        Message message = new Message();
        if(signatureDAO.insertSelective(signature)>0){
            message.setCode(1);
            message.setMessage("上传成功");
        }else {
            message.setCode(-1);
            message.setMessage("上传失败");
        }
        ;
        return  message;
    }
    @Override
    public Signature findByClazz(String clazz){
        return signatureDAO.findByClazz(clazz);
    }
}
