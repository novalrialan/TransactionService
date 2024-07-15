package com.transaction.dev.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        List<ProductDTO> products = service.getProducts();
        return new ResponseEntity<>(products, products.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO product) throws ProductCollectionException {
        try {
            service.createProduct(product);
            return new ResponseEntity<ProductDTO>(product, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(service.getSingleProduct(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable("id") String id, @RequestBody ProductDTO product) {
            try {
                service.updateProductId(id, product);
                return new ResponseEntity<>("Success Update Product : " + id, HttpStatus.OK);
            } catch (ProductCollectionException e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
            }
        
    }

    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") String id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>("Success Detele Product : " + id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
