package com.em.service;

import com.em.entity.ProductFeatureNames;

import java.util.List;

public interface ProductFeatureNamesService {

    ProductFeatureNames add(ProductFeatureNames productFeatureNames);
    List<ProductFeatureNames> addAll(List<ProductFeatureNames> productFeatureNamesList);
    List<ProductFeatureNames> getByVerticalId(long verticalId);
    List<ProductFeatureNames> findByVerticalIdAndIsFilterable(long verticalId, String isFilterable);
}
