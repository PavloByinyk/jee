package com.example.mongo1.repositories;

import com.example.mongo1.models.Pets;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PetsRepository extends MongoRepository<Pets, String > {

    Pets findBy_id(ObjectId id);

    List<Pets> findPetsByName(String name);

    //Supports native JSON query string
    @Query("{domain:'?0'}")
    Pets findCustomByDomain(String domain);

    @Query("{domain: { $regex: ?0 } })")
    List<Pets> findCustomByRegExDomain(String domain);
}
