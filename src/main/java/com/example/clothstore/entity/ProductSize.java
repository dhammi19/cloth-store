package com.example.clothstore.entity;

import com.example.clothstore.embedded.ProductSizeId;
import jakarta.persistence.*;

@Entity(name = "product_size")
public class ProductSize {
    @EmbeddedId
    private ProductSizeId id;

    @ManyToOne
    @MapsId("productId") // phải khớp tên field trong ProductSizeId
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @MapsId("sizeId") // phải khớp tên field trong ProductSizeId
    @JoinColumn(name = "size_id")
    private Size size;

    @Column(name = "product_size_quantity")
    private int productSizeQuantity;

    public ProductSizeId getId() {
        return id;
    }

    public void setId(ProductSizeId id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getProductSizeQuantity() {
        return productSizeQuantity;
    }

    public void setProductSizeQuantity(int productSizeQuantity) {
        this.productSizeQuantity = productSizeQuantity;
    }
}
