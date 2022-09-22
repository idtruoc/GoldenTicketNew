package com.example.goldenmovieticketnew.repositories;

import com.example.goldenmovieticketnew.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findByEmail(String email);
}
