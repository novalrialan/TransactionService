package model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;




@AllArgsConstructor
@NoArgsConstructor

@Data
@Document(collection = "products")
public class Product {
    @Id
    private Long productId;
    private String name;
    private String description;
    private Double price;
    private Integer stock;

 

    // Getters and setters
}
