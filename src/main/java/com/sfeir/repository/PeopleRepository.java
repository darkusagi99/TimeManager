package com.sfeir.repository;

import com.sfeir.model.People;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PeopleRepository extends MongoRepository<People, String> {

    People findByFullname(String fullname);

}
