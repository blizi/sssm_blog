package cn.blog.service.impl;

import cn.blog.dao.ContentDao;
import cn.blog.dao.UserDao;
import cn.blog.pojo.Markdown;
import cn.blog.pojo.User;
import cn.blog.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    ContentDao contentDao;
    @Autowired
    UserDao userDao;

    @Override
    public Markdown getContentByContentId(int id) {
        return contentDao.getContentByContentId(id);
    }

    @Override
    public void addContent(Markdown markdown) {
        markdown.setUid(1);                                    //默认设置为1.（暂时只有一个用户）
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str =  sd.format(new Date());
        markdown.setDate(str);
        contentDao.addContent(markdown);
    }

    @Override
    public List<Markdown> getContentByUserId(int id) {
        System.out.println(id);
        return  contentDao.getContentByUserId(id);
    }

    @Override
    public String getUserNameById(int id) {
        User user = userDao.getUserName(id);
        String name = user.getFirst_name()+user.getLast_name();
        return name;
    }
}
