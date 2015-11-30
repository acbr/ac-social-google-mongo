package com.avenuecode.repositories;

import com.avenuecode.mongo.MongoConnection;
import com.mongodb.Mongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ac-jlima on 11/29/15.
 */
@Repository
public interface UserConnectionInternalRepository extends MongoRepository<MongoConnection, String> {

    List<MongoConnection> findByProviderIdAndProviderUserId(String providerId, String providerUserId);


    MongoConnection findByUserId(String userId);

}
