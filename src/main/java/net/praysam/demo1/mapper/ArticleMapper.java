package net.praysam.demo1.mapper;

import net.praysam.demo1.pojo.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleMapper {
//注意：注解@Param用来给参数命名,命名之后就能根据名字得到参数值
    public Integer saveArticle(
            @Param("title") String title,
            @Param("author") String author,
            @Param("content") String content,
            @Param("file_name") String file_name
    );
    public Article getArticleById(@Param("id") Integer id);
}
