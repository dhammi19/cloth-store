package com.example.clothstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "size")
public class Size {
    @Id
    private String sizeId;

    @Column(name = "size_name")
    private String sizeName;

    @Temporal(TemporalType.DATE)
    @Column(name = "size_added_date")
    private Date sizeAddedDate;

    @JsonIgnore
    @OneToMany(mappedBy = "size")
    Set<ProductSize> productSizes;

    public String getSizeId() {
        return sizeId;
    }

    public void setSizeId(String sizeId) {
        this.sizeId = sizeId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public Date getSizeAddedDate() {
        return sizeAddedDate;
    }

    public void setSizeAddedDate(Date sizeAddedDate) {
        this.sizeAddedDate = sizeAddedDate;
    }

    public Set<ProductSize> getProductSizes() {
        return productSizes;
    }

    public void setProductSizes(Set<ProductSize> productSizes) {
        this.productSizes = productSizes;
    }
}
