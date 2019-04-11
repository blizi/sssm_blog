package cn.blog.dao;

import cn.blog.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> selectUser(Map<String,Object> map);
    List<User> allUser();
    User getUserName(@Param("id") int id);
}
