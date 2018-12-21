package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 缓存
 *
 * @author lyk
 * @date 2018/12/6
 **/
@Service
public class UserServiceImpl implements UserService {
    private static final Map<Long, User> DATABASES = new HashMap<>();
    static {
        DATABASES.put(1L, new User(1L, "u1", "p1"));
        DATABASES.put(2L, new User(2L, "u2", "p2"));
        DATABASES.put(3L, new User(3L, "u3", "p3"));
    }

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);



    @CachePut(value = "user",key = "#user.id")
    @Override
    public User saveOrUpdate(User user) {
        log.info("进入userService.saveOrUpdate()方法");
        DATABASES.put(user.getId(),user);
        return user;
    }

    @Cacheable(value = "user", key = "#id")
    @Override
    public User get(Long id) {
        log.info("进入userService.get()方法");
        return DATABASES.get(id);
    }

    @CacheEvict(value = "user",key = "#id")
    @Override
    public void delete(Long id) {
        log.info("进入userService.delete()方法");
        DATABASES.remove(id);
    }
}
