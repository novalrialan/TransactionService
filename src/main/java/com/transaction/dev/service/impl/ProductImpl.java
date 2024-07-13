package com.transaction.dev.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transaction.dev.dto.ProductDTO;
import com.transaction.dev.exception.ProductCollectionException;
import com.transaction.dev.repository.ProductRepository;
import com.transaction.dev.service.ProductService;

import jakarta.validation.ConstraintViolationException;






/**
 * ProductImpl
 */
@Service
public class ProductImpl implements ProductService{

    @Autowired
    private ProductRepository repository;


    @Override
    public void createProduct(ProductDTO productDTO)throws ProductCollectionException{
        try {
            Optional<ProductDTO> productsOptional = repository.findById(productDTO.getProductId());
            if (productsOptional.isPresent()) {
                throw new ProductCollectionException(ProductCollectionException.TransactionAlreadyExists());
            }else{
                productDTO.setCreatedAt(new Date(System.currentTimeMillis()));
                repository.save(productDTO);
            }
        } catch (ConstraintViolationException  e) {
            throw  new ProductCollectionException("Product get :"+e.getMessage());
        }
      
    }

  

   
    // public String toString() {
    //     return repository.toString();
    // }

    
}