package org.example.petblog.data.entity;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "articles")
public class Article {
    @Id
    String id;

    private String title;
    private String content;
    private String authorId;
    private Date publishedDate;
    private Set<String> tags = new HashSet<>();
}
