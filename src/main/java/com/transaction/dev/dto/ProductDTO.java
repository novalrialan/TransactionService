package com.transaction.dev.dto;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Unwrapped.Empty;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ProductDTO
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="product")
public class ProductDTO {

    @Id
    private String productId;
    // @NotNull(message="name cannot be null")
    @NotEmpty(message="name cannot be null")
    private String name;
    // @NotNull(message="description cannot be null")
    @NotEmpty(message="description cannot be null")
    private String description;
    @NotNull(message="price cannot be null")
    private Double price;
    @NotNull(message="stock cannot be null")
    private Integer stock;
    private Date createdAt;
    private Date updatedAt;
    
    // public ProductDTO(Long productId, String name, String description, Double price, Integer stock) {
    //     this.productId = productId;
    //     this.name = name;
    //     this.description = description;
    //     this.price = price;
    //     this.stock = stock;
    // }   

    // public void setCreatedAt(Date date) {
    //     throw new UnsupportedOperationException("Not supported yet.");
    // }

    // public void setCreatedAt(Date createdAt) {
    //     this.createdAt = createdAt;
    // }
}