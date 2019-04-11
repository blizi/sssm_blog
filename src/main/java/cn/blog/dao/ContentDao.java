package cn.blog.dao;

import cn.blog.pojo.Markdown;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContentDao {
    //add blog content
    void addContent(Markdown markdown);
    // get content by id
    Markdown getContentByContentId(@Param("id") int id);
    // get content by uid
    List<Markdown> getContentByUserId(@Param("id") int id);
}
