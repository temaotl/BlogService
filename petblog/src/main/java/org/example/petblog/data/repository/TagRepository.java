package org.example.petblog.data.repository;

import org.example.petblog.data.entity.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends MongoRepository <Tag,String> {

}
