package com.em.repository;

import com.em.entity.ProductFeatureCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductFeatureCategoryRepository extends JpaRepository<ProductFeatureCategory, Long> {

    List<ProductFeatureCategory> findByVerticalIdIn(long verticalIdArr[]);
}
