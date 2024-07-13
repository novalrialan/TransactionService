package com.transaction.dev.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class ProductImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public void createProduct(ProductDTO productDTO) throws ProductCollectionException {
        try {
            Optional<ProductDTO> productsOptional = repository.findById(productDTO.getProductId());
            if (productsOptional.isPresent()) {
                throw new ProductCollectionException(ProductCollectionException.TransactionAlreadyExists());
            } else {
                productDTO.setCreatedAt(new Date(System.currentTimeMillis()));
                repository.save(productDTO);
            }
        } catch (ConstraintViolationException e) {
            throw new ProductCollectionException("Product get :" + e.getMessage());
        }

    }

    @Override
    public List<ProductDTO> getProducts() {
        List<ProductDTO> productDTOs = repository.findAll();
        if (productDTOs.size() > 0) {
            return productDTOs;
        } else {
            return new ArrayList<ProductDTO>();
        }
    }

    
    @Override
    public ProductDTO getSingleProduct(String id) throws ProductCollectionException {
            Optional<ProductDTO> productsOptional = repository.findById(id);
            if (!productsOptional.isPresent()) {
                throw new ProductCollectionException(ProductCollectionException.NotFoundException(id));
            } else {
                return productsOptional.get();
            }
    }

    @Override
    public ProductDTO updateProductId(String id, ProductDTO productDTO) {
        // Optional<ProductDTO> productOptional = repository.findById(id);
        // if (productOptional.isPresent()) {
            
        // } else {
        // }
        return null;
    }

}
