package com.em.repository;

import com.em.entity.ProductFeatureNames;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductFeatureNamesRepository extends JpaRepository<ProductFeatureNames, Long> {

    List<ProductFeatureNames> findByProdVertId(long verticalId);
    List<ProductFeatureNames> findByProdVertIdAndIsFilterable(long verticalId, String isFilterable);
}
