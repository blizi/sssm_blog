package cn.blog.controller;

import cn.blog.pojo.Markdown;
import cn.blog.pojo.User;
import cn.blog.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.POST;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ContentController {

    @Autowired
    ContentService contentService;

    @ResponseBody
    @RequestMapping(value = "/mark")     //发表按钮
    public void mark(@RequestBody Markdown content){
        System.out.println(content.getContent());
        contentService.addContent(content);
    }
    @ResponseBody
    @GetMapping("getContent")
    public Map getContent(@RequestParam("id")int content_id){
        Map map = new HashMap();
        System.out.println(content_id);
        Markdown markdown = contentService.getContentByContentId(content_id);
        map.put("date",markdown.getDate());
        map.put("title",markdown.getTitle());
        map.put("content",markdown.getContent());
        map.put("id",markdown.getId());
        map.put("author",contentService.getUserNameById(markdown.getUid()));
        //String content = markdown.getContent();
        return map;
    }
    @ResponseBody
    @GetMapping(value = "userContent")     //用户id获取所有文章简单信息
    public List<Markdown> ContentByUser(int id){
        List<Markdown> list = contentService.getContentByUserId(id);
        return list;
    }
}
