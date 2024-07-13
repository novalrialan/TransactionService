package model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;






@Data
@Document(collection = "orders")// "order" is a reserved word in SQL, so we use "orders"
public class Order {
    @Id
    private Long orderId;
    private Date orderDate;
    private Double totalAmount;

  
    @DBRef
    private Customer customer;

    @DBRef
    private List<OrderItem> orderItems;

    // Getters and setters
}
