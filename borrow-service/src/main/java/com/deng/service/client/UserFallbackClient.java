package com.deng.service.client;

import com.deng.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserFallbackClient implements UserClient {
    @Override
    public User findUserById(int uid) {
        User user = new User();
        user.setName("我是补救措施");
        return user;
    }
}
