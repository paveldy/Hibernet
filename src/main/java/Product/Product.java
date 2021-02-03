package Product;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "person")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "productname", length = 128)
    private String productName;

    @Column(name = "price", length = 128)
    private float price;


    @Override
    public String toString() {
        return String.format("id: %s, productname: %s, price: %s", id, productName, price);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public Float getPrice() {
        return price;
    }

    public Product() {
    }

    public Product(String productName, float price) {
        this.productName = productName;
        this.price = price;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o)  return true;
        if (o == null)  return false;
        if (getClass() != o.getClass()) return false;
        Product product = (Product) o;
        if (this.id !=id&& this.productName.equals(product.productName)&&this.price==product.price) return true;



        return productName.equals(product.productName) &&  price==product.price && id==product.id;
    }


}
