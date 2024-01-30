package org.example.petblog.data;

import org.example.petblog.data.entity.Article;
import org.example.petblog.data.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
public class ArticleRepositoryRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void testAddAndRetrieveArticle() {
        Article newArticle = new Article();
        newArticle.setTitle("Test Title");
        newArticle.setContent("Test Content");
        newArticle.setAuthorId("1");
        newArticle.setPublishedDate(new Date());
        articleRepository.save(newArticle);


        Optional<Article> foundArticle = articleRepository.findById(newArticle.getId());
        assert (foundArticle.isPresent());
        assert (Objects.equals(foundArticle.get().getId(), newArticle.getId() ));

        articleRepository.deleteById(newArticle.getId());

        Optional<Article> deletedArticle = articleRepository.findById(newArticle.getId());
        assertFalse(deletedArticle.isPresent());

    }
}

