package com.em.repository;

import com.em.entity.ProductFeatureNameAndValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductFeatureNamesAndValuesRepository extends JpaRepository<ProductFeatureNameAndValue, Long> {

    @Query(value =  " SELECT epfn.id, epfn.prod_vert_id, epfn.prod_feature_name, epfn.feature_category_id, " +
            " epfv.id AS feature_value_id, epfv.prod_feature_id, epfv.product_id, epfv.prod_feature_value " +
            " FROM em_product_feature_names AS epfn " +
            " LEFT JOIN em_product_feature_values AS epfv ON epfn.id = epfv.prod_feature_id " +
            " WHERE epfn.prod_vert_id = :prodVertId AND epfv.product_id = :productId ",
            nativeQuery = true)
    List<ProductFeatureNameAndValue> findProductFeatureNamesAndValues(@Param("productId") long productId,
                                                                      @Param("prodVertId") long prodVertId);
}
