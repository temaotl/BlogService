package org.example.petblog.data;

import org.example.petblog.data.entity.Tag;
import org.example.petblog.data.repository.TagRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Objects;
import java.util.Optional;

@DataMongoTest
public class TagRepositoryTest {

    @Autowired
    private TagRepository tagRepository;

    @Test
    public void  RepositoryMustSaveTag()
    {
        Tag createdTag = new Tag();
        createdTag.setName("Movie");
        tagRepository.save(createdTag);

        Optional<Tag> foundedTag = tagRepository.findById(createdTag.getId());
        assert (foundedTag.isPresent());
        assert (Objects.equals( foundedTag.get().getName(),  createdTag.getName()  ));
    }


}
