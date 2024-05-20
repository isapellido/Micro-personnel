package net.praysam.demo1.controller;

import net.praysam.demo1.pojo.Article;
import net.praysam.demo1.service.ArticleService;
import net.praysam.demo1.util.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("add")
    public ResultBean addArticle(Article article){
        System.out.println("添加article对象为"+article.toString());
        Integer result = articleService.addArticle(article);
        if (result >= 0) {
            return ResultBean.success(result);
        }
        return ResultBean.error(1,"添加article失败");
    }

    @PostMapping("get/{id}")
    public ResultBean getArticle(@PathVariable("id") Integer id){
        Long start = System.currentTimeMillis();
        Article article = articleService.getArticle(id);
        Long end = System.currentTimeMillis();
        System.out.println("耗时："+(end-start)+"毫秒");

        if (article != null) {
            return ResultBean.success("查询成功");
        }
        return ResultBean.error(2,"获取article失败");
    }
}
