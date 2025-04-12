package com.rickey.server;

import com.rickey.User;
import com.rickey.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;

/**
 * @Description:
 * @Author: rickey-c
 * @Date: 2025/4/9 14:00
 */
@Slf4j
public class UserServiceImpl implements UserService.Iface {
    @Override
    public User getById(int id) throws TException {
        log.info("getById 方法执行...");
        User user = new User();
        user.setId(id);
        user.setName("rickey");
        user.setAge(20);
        return user;
    }

    @Override
    public boolean isExist(String name) throws TException {
        return false;
    }
}
