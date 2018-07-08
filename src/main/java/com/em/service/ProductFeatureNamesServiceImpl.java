package com.em.service;

import com.em.entity.ProductFeatureNames;
import com.em.repository.ProductFeatureNamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productFeatureNamesService")
public class ProductFeatureNamesServiceImpl implements ProductFeatureNamesService {

    @Autowired
    private ProductFeatureNamesRepository productFeatureNamesRepository;

    @Override
    @Transactional
    public ProductFeatureNames add(ProductFeatureNames productFeatureNames) {
        return this.productFeatureNamesRepository.save(productFeatureNames);
    }

    @Override
    public List<ProductFeatureNames> addAll(List<ProductFeatureNames> productFeatureNamesList) {
        return this.productFeatureNamesRepository.save(productFeatureNamesList);
    }

    @Override
    public List<ProductFeatureNames> getByVerticalId(long verticalId) {
        return this.productFeatureNamesRepository.findByProdVertId(verticalId);
    }
}
