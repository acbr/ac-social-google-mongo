package com.avenuecode.repositories;

import com.avenuecode.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ac-jlima on 11/29/15.
 */
@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    

}
