package cn.gebixiaoba.dao;

import cn.gebixiaoba.entity.Warehouseman;
import cn.gebixiaoba.entity.WarehousemanOrderBook;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * WarehousemanDAO继承基类
 */
@Repository
public interface WarehousemanDAO extends MyBatisBaseDao<Warehouseman, String> {
    Warehouseman findByNameAndPassword(Warehouseman warehouseman);
    List<WarehousemanOrderBook> findAllOrderBook();
}