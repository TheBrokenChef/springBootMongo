package com.chefscode.springBootMongo.repository;

import com.chefscode.springBootMongo.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, String> {
}
