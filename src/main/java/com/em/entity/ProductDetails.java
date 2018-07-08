package com.em.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ANIMUS on 23-08-2017.
 */
@Entity
@Table(name = "em_product")
public class ProductDetails implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "product_name")
    private String productName;
    @Column(name = "selling_rate")
    private int sellingRate;
    @Column(name = "mrp")
    private int mrp;

    @Column(name = "image1")
    private String image1;
    @Column(name = "image2")
    private String image2;
    @Column(name = "image3")
    private String image3;
    @Column(name = "image4")
    private String image4;
    @Column(name = "image5")
    private String image5;
    @Column(name = "state")
    private String state;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "vertical_id")
    private long verticalId;


    @Column(name = "feature_category_names")
    private String featureCategoryNames;
    @Column(name = "key_feature_states")
    private String keyFeatureStates;
    @Column(name = "feature_names")
    private String featureNames;
    @Column(name = "feature_values")
    private String featureValues;


    public ProductDetails() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSellingRate() {
        return sellingRate;
    }

    public void setSellingRate(int sellingRate) {
        this.sellingRate = sellingRate;
    }

    public int getMrp() {
        return mrp;
    }

    public void setMrp(int mrp) {
        this.mrp = mrp;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getImage5() {
        return image5;
    }

    public void setImage5(String image5) {
        this.image5 = image5;
    }

    public String getFeatureNames() {
        return featureNames;
    }

    public void setFeatureNames(String featureNames) {
        this.featureNames = featureNames;
    }

    public String getFeatureValues() {
        return featureValues;
    }

    public void setFeatureValues(String featureValues) {
        this.featureValues = featureValues;
    }

    public String getFeatureCategoryNames() {
        return featureCategoryNames;
    }

    public void setFeatureCategoryNames(String featureCategoryNames) {
        this.featureCategoryNames = featureCategoryNames;
    }

    public long getVerticalId() {
        return verticalId;
    }

    public void setVerticalId(long verticalId) {
        this.verticalId = verticalId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getKeyFeatureStates() {
        return keyFeatureStates;
    }

    public void setKeyFeatureStates(String keyFeatureStates) {
        this.keyFeatureStates = keyFeatureStates;
    }
}
