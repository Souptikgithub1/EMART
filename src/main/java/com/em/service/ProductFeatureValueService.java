package com.em.service;

import com.em.entity.ProductFeatureNameAndValue;
import com.em.entity.ProductFeatureValues;

import java.util.List;
import java.util.Map;

public interface ProductFeatureValueService {

    List<ProductFeatureValues> addAll(List<ProductFeatureValues> productFeatureValuesList);
    List<ProductFeatureNameAndValue> get(long productId, long prodVertId);
    void deleteByProductId(long productId);
    List<Long> getProductIdsByFilteringFeatureValues(List<Map<String, Object>> filters);
}
