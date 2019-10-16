package dao.impl;

import dao.accountDao;
import org.springframework.stereotype.Repository;

/**
 * 使用注解方式实现持久层
 */
@Repository("anno_Dao")
public class accountDaoImpl_anno implements accountDao {

    @Override
    public void saveAccount() {
        System.out.println("保存成功!");
    }
}
