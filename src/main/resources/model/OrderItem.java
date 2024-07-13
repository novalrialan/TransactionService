package model;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;





@Data
@Document(collection = "orderItems")
public class OrderItem {
    @Id
    private Long orderItemId;
    private Integer quantity;
    private Double subtotal;

    @DBRef
    private Order order;

    @DBRef
    private Product product;

    // Getters and setters
}
