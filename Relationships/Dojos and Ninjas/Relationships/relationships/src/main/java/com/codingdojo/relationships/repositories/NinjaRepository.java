package com.codingdojo.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codingdojo.relationships.models.Ninja;


@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{
 // this method retrieves all the ninjas from the database
 List<Ninja> findAll();
}