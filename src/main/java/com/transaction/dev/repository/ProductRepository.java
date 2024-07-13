/**
 * ProductRepository
 */
package com.transaction.dev.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.transaction.dev.dto.ProductDTO;



@Repository
public interface ProductRepository extends MongoRepository<ProductDTO,String>{

    @Query("{'product':?0}")
    Optional<ProductDTO> findByProducts(String product);
    
}