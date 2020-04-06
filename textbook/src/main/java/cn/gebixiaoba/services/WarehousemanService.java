package cn.gebixiaoba.services;

import cn.gebixiaoba.bean.Message;
import cn.gebixiaoba.entity.Signature;
import cn.gebixiaoba.entity.Warehouseman;
import cn.gebixiaoba.entity.WarehousemanOrderBook;

import java.util.List;

/**
 * Created by Administrator on 2020/3/27.
 */
public interface WarehousemanService {
    Warehouseman checkout(Warehouseman warehouseman);
    List<WarehousemanOrderBook> findAllOrderBook();
    Message upload(Signature signature);
    Signature findByClazz(String clazz);
}
