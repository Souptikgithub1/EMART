package com.em.entity;

import javax.persistence.*;

@Entity
@Table(name = "em_product_feature_category")
public class ProductFeatureCategory {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "feature_category_name")
    private String featureCategoryName;

    @Column(name = "vertical_id")
    private long verticalId;

    public ProductFeatureCategory() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFeatureCategoryName() {
        return featureCategoryName;
    }

    public void setFeatureCategoryName(String featureCategoryName) {
        this.featureCategoryName = featureCategoryName;
    }

    public long getVerticalId() {
        return verticalId;
    }

    public void setVerticalId(long verticalId) {
        this.verticalId = verticalId;
    }
}
