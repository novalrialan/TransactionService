import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * CustomerDTO
 */
@Getter
@Setter
@NoArgsConstructor
public class CustomerDTO {

    public Long CustomerId;
    public String name;
    public String email;
    public String phone;
    public String address;
    List<OrderDto> orderDto;

    public CustomerDTO(Long customerId, String name, String email, String phone, String address,Long orderDto) {
        CustomerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.orderDto = orderDto;
    }

    
}