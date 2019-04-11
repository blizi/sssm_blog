package cn.blog.service;

import cn.blog.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> selectUser(Map<String,Object> map);
    List<User> allUser();
}
