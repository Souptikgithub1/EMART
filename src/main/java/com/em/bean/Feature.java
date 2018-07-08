package com.em.bean;

public class Feature {

    private String name;
    private String keyFeatureState;
    private String value;
    private String category;

    public Feature() {
        super();
    }

    public Feature(String name, String keyFeatureState, String value, String category) {
        this.name = name;
        this.keyFeatureState = keyFeatureState;
        this.value = value;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getKeyFeatureState() {
        return keyFeatureState;
    }

    public void setKeyFeatureState(String keyFeatureState) {
        this.keyFeatureState = keyFeatureState;
    }
}
