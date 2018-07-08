package com.em.bean;

import com.em.entity.Brand;
import com.em.entity.Category;

import java.util.List;
import java.util.Map;

public class ProductDetailsBean {

    private long id;

    private String productName;

    private int sellingRate;

    private int mrp;


    private String image1;

    private String image2;

    private String image3;

    private String image4;

    private String image5;

    private String state;

    private Brand brand;


    private Category category;

    private long verticalId;

    private String featureNames;

    private String keyFeatureStates;

    private String featureValues;

    private String featureCategoryNames;

    private List<Feature> featureList;


    public ProductDetailsBean() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public List<Feature> getFeatureList() {
        return featureList;
    }

    public void setFeatureList(List<Feature> featureList) {
        this.featureList = featureList;
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
