package com.em.repository;

import com.em.entity.ProductFeatureNameAndValue;
import com.em.entity.ProductFeatureValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductFeatureValueRepository extends JpaRepository<ProductFeatureValues, Long> {

    void deleteByProductId(long productId);
}
