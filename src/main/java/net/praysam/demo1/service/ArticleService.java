package net.praysam.demo1.service;

import net.praysam.demo1.mapper.ArticleMapper;
import net.praysam.demo1.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
@CacheConfig(cacheNames = "articleCache")
public class ArticleService {
    private AtomicInteger count = new AtomicInteger(0);

    @Autowired
    private ArticleMapper articleMapper;

    @CachePut(value = "articleCache")
    @CacheEvict(allEntries = true)
    public Integer addArticle(Article article){
        Integer result = articleMapper.saveArticle(
                article.getTitle(),
                article.getAuthor(),
                article.getContent(),
                article.getFile_name()
                );
        return result;
    }

    @Cacheable
    public Article getArticle(Integer id){
        System.out.println("进入getArticle()方法");
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        final  Article article = articleMapper.getArticleById(id);
        System.out.println("执行数据库查询操作"+count.incrementAndGet()+"次，id:"+id);
        return article;
    }
}
