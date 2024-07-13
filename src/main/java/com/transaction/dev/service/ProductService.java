/**
 * ProductService
 */

 
package com.transaction.dev.service;

import com.transaction.dev.dto.ProductDTO;
import com.transaction.dev.exception.ProductCollectionException;


public interface ProductService {

    // List<ProductDTO> getProducts();

    public void createProduct(ProductDTO productDTO) throws ProductCollectionException;
}