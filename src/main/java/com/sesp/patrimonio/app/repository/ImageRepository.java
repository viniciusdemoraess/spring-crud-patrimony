package com.sesp.patrimonio.app.repository;

import com.sesp.patrimonio.app.models.ImageField;

// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends MongoRepository<ImageField, String>{
    
}
