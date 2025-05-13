package com.example.clothstore.embedded;

import java.io.Serializable;
import java.util.Objects;

public class CartId implements Serializable {
    private String customerId;
    private String productId;
    private String sizeId;

    public CartId() {};

    public CartId(String customerId, String productId, String sizeId) {
        this.customerId = customerId;
        this.productId = productId;
        this.sizeId = sizeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartId that)) return false;
        return Objects.equals(customerId, that.customerId)
                && Objects.equals(productId, that.productId)
                && Objects.equals(sizeId, that.sizeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, productId, sizeId);
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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
