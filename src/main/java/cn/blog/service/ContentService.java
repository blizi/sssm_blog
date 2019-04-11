package cn.blog.service;

import cn.blog.pojo.Markdown;

import java.util.List;

public interface ContentService {
    //根据文章id获取内容
    Markdown getContentByContentId(int id);
    //创建博客
    void addContent(Markdown markdown);
    //
    List<Markdown> getContentByUserId(int id);
    //get user name
    String getUserNameById(int id);
}
