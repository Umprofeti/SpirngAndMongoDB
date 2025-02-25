package com.skiatel.spingmongodb.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends MongoRepository<com.skiatel.spingmongodb.DAO.User, String> {

}
