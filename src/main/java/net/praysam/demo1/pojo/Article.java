package net.praysam.demo1.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

//    private Integer id;

    private String title;

    private String author;

    private String content;

    private String file_name;

//    private Integer state;

    }