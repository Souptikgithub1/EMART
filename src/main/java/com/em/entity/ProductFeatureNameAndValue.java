package com.em.entity;

import javax.persistence.*;


@Entity
@Table(name = "product_feature_name_and_value")
public class ProductFeatureNameAndValue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "prod_vert_id")
    private long prodVertId;

    @Column(name = "prod_feature_name")
    private String prodFeatureName;

    @Column(name = "feature_category_id")
    private long featureCategoryId;



    @Column(name = "feature_value_id")
    private long featureValueId;

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

    public long getProdVertId() {
        return prodVertId;
    }

    public void setProdVertId(long prodVertId) {
        this.prodVertId = prodVertId;
    }

    public String getProdFeatureName() {
        return prodFeatureName;
    }

    public void setProdFeatureName(String prodFeatureName) {
        this.prodFeatureName = prodFeatureName;
    }

    public long getFeatureCategoryId() {
        return featureCategoryId;
    }

    public void setFeatureCategoryId(long featureCategoryId) {
        this.featureCategoryId = featureCategoryId;
    }

    public long getFeatureValueId() {
        return featureValueId;
    }

    public void setFeatureValueId(long featureValueId) {
        this.featureValueId = featureValueId;
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
