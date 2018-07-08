package com.em.service;

import com.em.entity.ProductFeatureNameAndValue;
import com.em.entity.ProductFeatureValues;

import java.util.List;

public interface ProductFeatureValueService {

    List<ProductFeatureValues> addAll(List<ProductFeatureValues> productFeatureValuesList);
    List<ProductFeatureNameAndValue> get(long productId, long prodVertId);
    void deleteByProductId(long productId);
}
