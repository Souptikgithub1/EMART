package com.em.entity;


import javax.persistence.*;

@Entity
@Table(name = "em_product_feature_values")
public class ProductFeatureValues {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "prod_feature_id")
    private long prodFeatureId;

    @Column(name = "product_id")
    private long productId;

    @Column(name = "prod_feature_value")
    private String prodFeatureValue;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProdFeatureId() {
        return prodFeatureId;
    }

    public void setProdFeatureId(long prodFeatureId) {
        this.prodFeatureId = prodFeatureId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProdFeatureValue() {
        return prodFeatureValue;
    }

    public void setProdFeatureValue(String prodFeatureValue) {
        this.prodFeatureValue = prodFeatureValue;
    }
}
