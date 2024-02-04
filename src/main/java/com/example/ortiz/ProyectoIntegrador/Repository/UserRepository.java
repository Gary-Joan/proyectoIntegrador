package com.example.ortiz.ProyectoIntegrador.Repository;
import com.example.ortiz.ProyectoIntegrador.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    // Métodos CRUD proporcionados por MongoRepository
}
