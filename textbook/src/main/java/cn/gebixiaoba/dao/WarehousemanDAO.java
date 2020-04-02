package cn.gebixiaoba.dao;

import cn.gebixiaoba.entity.Warehouseman;
import org.springframework.stereotype.Repository;

/**
 * WarehousemanDAO继承基类
 */
@Repository
public interface WarehousemanDAO extends MyBatisBaseDao<Warehouseman, String> {
    Warehouseman findByNameAndPassword(Warehouseman warehouseman);
}