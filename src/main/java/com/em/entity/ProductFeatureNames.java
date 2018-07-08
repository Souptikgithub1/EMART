package com.em.entity;

import javax.persistence.*;

@Entity
@Table(name = "em_product_feature_names")
public class ProductFeatureNames {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "prod_vert_id")
    private long prodVertId;

    @Column(name = "prod_feature_name")
    private String prodFeatureName;

    @Column(name = "feature_category_id")
    private long featureCategoryId;

    @Column(name = "is_filterable")
    private String isFilterable;

    @Column(name = "is_key_feature")
    private String isKeyFeature;


    public ProductFeatureNames() {
        super();
    }

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

    public String getIsFilterable() {
        return isFilterable;
    }

    public void setIsFilterable(String isFilterable) {
        this.isFilterable = isFilterable;
    }

    public String getIsKeyFeature() {
        return isKeyFeature;
    }

    public void setIsKeyFeature(String isKeyFeature) {
        this.isKeyFeature = isKeyFeature;
    }
}
