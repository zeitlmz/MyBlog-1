package com.wei.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wei.entity.Article;

import java.util.List;

/**
 * (Essay)表服务接口
 *
 * @author makejava
 * @since 2020-05-02 12:46:41
 */
public interface ArticleService extends IService<Article> {

    /**
     * 查询所有文章内容 根据时间排序
     * @return 所有文章
     */
    List<Article> findAll();

    /**
     *通过id查询文章
     * @param artId 文章id
     * @return 文章对象
     */
    Article selectByArtId(Integer artId);
}