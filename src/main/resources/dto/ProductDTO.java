/**
 * ProductDTO
 */
public class ProductDTO {

    private Long productId;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    
    public ProductDTO(Long productId, String name, String description, Double price, Integer stock) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }   

    
}