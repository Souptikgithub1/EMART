package com.em.service;

import com.em.entity.ProductFeatureCategory;
import com.em.repository.ProductFeatureCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productFeatureCategoryService")
public class ProductFeatureCategoryServiceImpl implements ProductFeatureCategoryService {

    @Autowired
    private ProductFeatureCategoryRepository productFeatureCategoryRepository;

    @Override
    @Transactional
    public List<ProductFeatureCategory> getAll() {
        return this.productFeatureCategoryRepository.findAll();
    }

    @Override
    public List<ProductFeatureCategory> getAllByVerticalId(long verticalIdArr[]) {
        return this.productFeatureCategoryRepository.findByVerticalIdIn(verticalIdArr);
    }
}
