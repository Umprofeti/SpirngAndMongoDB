package com.skiatel.spingmongodb.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<com.skiatel.spingmongodb.DAO.Product, String> {

}