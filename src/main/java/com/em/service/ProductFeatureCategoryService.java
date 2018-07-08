package com.em.service;

import com.em.entity.ProductFeatureCategory;

import java.util.List;

public interface ProductFeatureCategoryService {
    List<ProductFeatureCategory> getAll();
    List<ProductFeatureCategory> getAllByVerticalId(long verticalIdArr[]);
}
