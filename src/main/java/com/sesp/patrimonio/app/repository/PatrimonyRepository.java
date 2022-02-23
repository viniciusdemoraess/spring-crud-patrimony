package com.sesp.patrimonio.app.repository;

import com.sesp.patrimonio.app.models.Patrimony;

// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatrimonyRepository extends MongoRepository<Patrimony, String>{

    Patrimony findByPatrimonio(String patrimonio);
    
}
