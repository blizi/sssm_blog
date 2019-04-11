package cn.blog.controller;

import cn.blog.pojo.User;
import cn.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;




    @ResponseBody
    @RequestMapping(value = "allUser")
    public List<User> selectAllUser(){
        List<User> list;
        System.out.println("allUSer");
        list = userService.allUser();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getFirst_name()+list.get(i).getLast_name());
        }
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "selectUserAsJson")
    public List<User> selectUserAsJson(String id){
        List<User> users = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        users = userService.selectUser(map);
        return users;
    }

    @RequestMapping(value = "selectUserAsJsp")
    public ModelAndView selectUserAsJsp(String id){
        List<User> users ;
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        users = userService.selectUser(map);
        ModelAndView model = new ModelAndView();
        model.addObject("users",users);
        model.setViewName("index");
        return model;
    }
}