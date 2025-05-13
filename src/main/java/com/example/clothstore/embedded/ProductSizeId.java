package com.example.clothstore.embedded;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductSizeId implements Serializable {
    private String productId;
    private String sizeId;

    public ProductSizeId(){}

    public ProductSizeId(String productId, String sizeId) {
        this.productId = productId;
        this.sizeId = sizeId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductSizeId)) return false;
        ProductSizeId that = (ProductSizeId) o;
        return Objects.equals(productId, that.productId) && Objects.equals(sizeId, that.sizeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, sizeId);
    }
}
