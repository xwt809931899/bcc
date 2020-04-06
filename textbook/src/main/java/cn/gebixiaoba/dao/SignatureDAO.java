package cn.gebixiaoba.dao;

import cn.gebixiaoba.entity.Signature;
import org.springframework.stereotype.Repository;

/**
 * SignatureDAO继承基类
 */
@Repository
public interface SignatureDAO extends MyBatisBaseDao<Signature, Signature> {
    Signature findByClazz(String clazz);
}