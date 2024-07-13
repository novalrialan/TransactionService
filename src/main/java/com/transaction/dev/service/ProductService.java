/**
 * ProductService
 */

package com.transaction.dev.service;

import java.util.List;

import com.transaction.dev.dto.ProductDTO;
import com.transaction.dev.exception.ProductCollectionException;


public interface ProductService {

    
    public void createProduct(ProductDTO productDTO) throws ProductCollectionException;
    
    public List<ProductDTO> getProducts();

    public ProductDTO getSingleProduct(String id)throws ProductCollectionException;

    public ProductDTO updateProductId(String id, ProductDTO productDTO);
}