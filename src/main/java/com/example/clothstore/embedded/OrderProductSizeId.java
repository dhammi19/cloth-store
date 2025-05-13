package com.example.clothstore.embedded;

import java.io.Serializable;
import java.util.Objects;

public class OrderProductSizeId implements Serializable {
    private String orderId;
    private String productId;
    private String sizeId;

    public OrderProductSizeId() {}

    public OrderProductSizeId(String orderId, String productId, String sizeId) {
        this.orderId = orderId;
        this.productId = productId;
        this.sizeId = sizeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderProductSizeId that)) return false;
        return Objects.equals(orderId, that.orderId)
                && Objects.equals(productId, that.productId)
                && Objects.equals(sizeId, that.sizeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productId, sizeId);
    }

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
}
