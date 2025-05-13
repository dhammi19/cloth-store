package com.example.clothstore.entity;

import com.example.clothstore.embedded.OrdersProductSizeId;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "orders_product_size")
/*
 * Annotation @IdClass trong JPA dùng để định nghĩa khóa chính tổng hợp
 * (composite primary key) cho một entity. Nó cho JPA biết rằng
 * khóa chính của entity đó bao gồm nhiều cột, và cấu trúc khóa này
 * được định nghĩa trong một class riêng biệt (ví dụ: OrdersProductSizeId).
 */
@IdClass(OrdersProductSizeId.class)
public class OrderProductSize {
    @Id
    @Column(name = "order_id")
    private String orderId;

    @Id
    @Column(name = "product_id")
    private String productId;

    @Id
    @Column(name = "size_id")
    private String sizeId;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false),
            @JoinColumn(name = "size_id", referencedColumnName = "size_id", insertable = false, updatable = false)
    })
    private ProductSize productSize;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSizeId() {
        return sizeId;
    }

    public void setSizeId(String sizeId) {
        this.sizeId = sizeId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ProductSize getProductSize() {
        return productSize;
    }

    public void setProductSize(ProductSize productSize) {
        this.productSize = productSize;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
