package com.sfeir.repository;

import com.sfeir.model.Presence;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PresenceRepository extends MongoRepository<Presence, String> {

    List<Presence> findByPersonId(String personId);

}
