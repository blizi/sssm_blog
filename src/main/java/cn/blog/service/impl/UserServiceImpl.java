package cn.blog.service.impl;

import cn.blog.dao.UserDao;
import cn.blog.pojo.User;
import cn.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;
    @Override
    public List<User> selectUser(Map<String,Object> map) {
        return userDao.selectUser(map);
    }
    public List<User> allUser(){
        return userDao.allUser();
    }
}