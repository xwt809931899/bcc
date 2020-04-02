package cn.gebixiaoba.imp;

import cn.gebixiaoba.dao.WarehousemanDAO;
import cn.gebixiaoba.entity.Warehouseman;
import cn.gebixiaoba.services.WarehousemanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2020/3/27.
 */
@Service
public class WarehousemanImp implements WarehousemanService {

    @Autowired
    private WarehousemanDAO warehousemanDAO;
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
}
