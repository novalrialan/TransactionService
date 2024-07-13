package model;


import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document(collection = "customers")
public class Customer {
    @Id
    private Long customerId;
    private String name;
    private String email;
    private String phone;
    private String address;

    @DBRef
    private List<Order> orders;

    // Getters and setters
}
