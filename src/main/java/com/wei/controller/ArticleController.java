package com.wei.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.wei.entity.Article;
import com.wei.entity.vo.ArticleVo;
import com.wei.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Essay)表控制层
 *
 * @author makejava
 * @since 2020-05-02 12:46:41
 */
@CrossOrigin
@RestController
@RequestMapping("article")
public class ArticleController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ArticleService articleService;

    @RequestMapping("selectByArtId")
    public ArticleVo selectByArtId(Integer artId) {
        if (artId == null) {
            artId = 1;
        }
        return articleService.selectByArtId(artId);
    }

    @GetMapping("selectTopArticleByUid")
    public List<Article> selectTopArticleByUid(Integer uid) {
        if (uid == null) {
            return findAllTopArticle();
        }
        return articleService.selectTopArticleByUid(uid);
    }

    @GetMapping("selectNoTopArticleByUid")
    public List<Article> selectNoTopArticleByUid(Integer uid) {
        if (uid == null) {
           return findAllNoTopArticle();
        }
        return articleService.selectNoTopArticleByUid(uid);
    }

    @GetMapping("findAllTopArticle")
    public List<Article> findAllTopArticle() {
        return articleService.findAllTopArticle();
    }

    @GetMapping("findAllNoTopArticle")
    public List<Article> findAllNoTopArticle() {
        return articleService.findAllNoTopArticle();
    }
}