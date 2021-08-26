package com.spring5.service;

import com.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lichuang
 * @create 2021-08-26 15:50
 * @project_name spring5
 */
@Service
//@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ,timeout = -1,readOnly = false,rollbackFor = {RuntimeException.class})
public class UserService {

    // 注入Dao
    @Autowired
    private UserDao userDao;

    // 转账的方法
//    @Transactional // 也可以放在类上面
    public void accountMoney(){
//        try {
            // 1. 开启事务

            // 2. 进行业务操作
            // lucy少100
            userDao.reduceMoney();

//        int i = 12 / 0; // 需要使用事务

            // mary多100
            userDao.addMoney();

            // 3. 没有异常，提交事务
//        }catch (Exception e){
            // 4. 出现异常，回滚事务
//            e.printStackTrace();
//        }
    }

}
