package com.example.clothstore.entity;

import com.example.clothstore.embedded.ProductSizeId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "product_size")
public class ProductSize {
    @EmbeddedId
    private ProductSizeId id;

    @ManyToOne
    @MapsId("product") // phải khớp tên field trong ProductSizeId
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @MapsId("size") // phải khớp tên field trong ProductSizeId
    @JoinColumn(name = "size_id")
    private Size size;

    @Column(name = "product_size_quantity")
    private int productSizeQuantity;

    @JsonIgnore
    @OneToMany(mappedBy = "productSize")
    private Set<OrderProductSize> orderProductSizes;

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

    public Set<OrderProductSize> getOrderProductSizes() {
        return orderProductSizes;
    }

    public void setOrderProductSizes(Set<OrderProductSize> orderProductSizes) {
        this.orderProductSizes = orderProductSizes;
    }
}
