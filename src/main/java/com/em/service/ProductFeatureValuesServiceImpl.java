package com.em.service;

import com.em.entity.ProductFeatureNameAndValue;
import com.em.entity.ProductFeatureValues;
import com.em.repository.ProductFeatureNamesAndValuesRepository;
import com.em.repository.ProductFeatureValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productFeatureValueService")
public class ProductFeatureValuesServiceImpl implements ProductFeatureValueService {

    @Autowired
    private ProductFeatureValueRepository productFeatureValueRepository;

    @Autowired
    private ProductFeatureNamesAndValuesRepository productFeatureNamesAndValuesRepository;

    @Override
    public List<ProductFeatureValues> addAll(List<ProductFeatureValues> productFeatureValuesList) {
        return this.productFeatureValueRepository.save(productFeatureValuesList);
    }

    @Override
    public List<ProductFeatureNameAndValue> get(long productId, long prodVertId) {
        return this.productFeatureNamesAndValuesRepository.findProductFeatureNamesAndValues(productId, prodVertId);
    }

    @Override
    @Transactional
    public void deleteByProductId(long productId) {
        this.productFeatureValueRepository.deleteByProductId(productId);
    }
}
