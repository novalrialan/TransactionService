package com.transaction.dev.controller;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.dev.dto.ProductDTO;
import com.transaction.dev.exception.ProductCollectionException;
import com.transaction.dev.repository.ProductRepository;
import com.transaction.dev.service.ProductService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;



/**
 * ProductController
 */

@RestController
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductService service;

  
    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() {
        List<ProductDTO> products = repository.findAll();
        if (products.size() > 0) {
            return new ResponseEntity<List<ProductDTO>>(products,HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Products available",HttpStatus.NOT_FOUND);
        }
        
    }

    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO product) throws ProductCollectionException {
        try {
            // product.setCreatedAt(new Date(System.currentTimeMillis()));
            // repository.save(product);
            service.createProduct(product);
            return new ResponseEntity<ProductDTO>(product,HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
        }
       
    }

    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") String id) {
       try {
        repository.deleteById(id);
        return new ResponseEntity<>("Success Detele Product : "+id,HttpStatus.OK);
       } catch (Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
       }
    }
    
}