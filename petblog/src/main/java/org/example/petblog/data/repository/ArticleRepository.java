package org.example.petblog.data.repository;




import org.example.petblog.data.entity.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ArticleRepository extends MongoRepository<Article,String> {
}
