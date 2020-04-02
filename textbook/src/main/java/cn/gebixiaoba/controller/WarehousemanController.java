package cn.gebixiaoba.controller;

import cn.gebixiaoba.entity.Warehouseman;
import cn.gebixiaoba.services.WarehousemanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2020/3/27.
 */
@Controller
@RequestMapping("warehouseman")
public class WarehousemanController {

    @Autowired
    private WarehousemanService warehousemanService;
    @RequestMapping("login")
    @ResponseBody
    public Warehouseman login(Warehouseman warehouseman){
        return warehousemanService.checkout(warehouseman);
    }

}
