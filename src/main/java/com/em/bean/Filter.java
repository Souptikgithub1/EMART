package com.em.bean;

import java.util.List;

public class Filter {
    private String featureId;
    private List<String> featureValues;

    public Filter() {
        super();
    }

    public String getFeatureId() {
        return featureId;
    }

    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }

    public List<String> getFeatureValues() {
        return featureValues;
    }

    public void setFeatureValues(List<String> featureValues) {
        this.featureValues = featureValues;
    }
}
