package com.em.repository;

import com.em.entity.ProductDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Stream;

public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Serializable> {

    @Query(value =  " SELECT ep.*, " +
            " ec.id AS categoryId, ec.name, ec.search_result_name, ec.parent_id, ec.state, ec.is_vertical, ec.is_leaf, " +
            " eb.id AS brandId, eb.brand_name, eb.brand_display_name, " +
            " GROUP_CONCAT(epfn.prod_feature_name SEPARATOR '|') AS feature_names, " +
            " GROUP_CONCAT(epfn.is_key_feature SEPARATOR '|') AS key_feature_states, " +
            " GROUP_CONCAT(epfv.prod_feature_value SEPARATOR '|') AS feature_values, " +
            " GROUP_CONCAT(epfc.feature_category_name SEPARATOR '|') AS feature_category_names " +
            " FROM em_product AS ep " +
            " LEFT JOIN em_category AS ec ON ep.category_id = ec.id " +
            " LEFT JOIN em_brand AS eb ON ep.brand_id = eb.id " +
            " INNER JOIN em_product_feature_names AS epfn ON epfn.prod_vert_id = ep.vertical_id " +
            " INNER JOIN em_product_feature_values AS epfv ON epfv.prod_feature_id = epfn.id AND epfv.product_id = ep.id " +
            " LEFT JOIN em_product_feature_category AS epfc ON epfn.feature_category_id = epfc.id " +
            " WHERE ep.id = :productId ", nativeQuery = true)
    List<ProductDetails> getSingleProduct(@Param("productId") long productId);

    /*
     *
      * @Query(value =  " SELECT ep.*, " +
            " ec.id AS categoryId, ec.name, ec.search_result_name, ec.parent_id, ec.state, ec.is_vertical " +
            " eb.id AS brandId, eb.brand_name, eb.brand_display_name, " +
            " GROUP_CONCAT(epfn.prod_feature_name SEPARATOR ',') AS feature_names, " +
            " GROUP_CONCAT(epfv.prod_feature_value SEPARATOR ',') AS feature_values, " +
            " GROUP_CONCAT(epfc.feature_category_name SEPARATOR ',') AS feature_category_names " +
            " FROM em_category AS ec " +
            " LEFT JOIN em_product AS ep ON ec.id = ep.category_id " +
            " LEFT JOIN em_brand AS eb ON ep.brand_id = eb.id " +
            " INNER JOIN em_product_feature_names AS epfn " +
            " ON epfn.prod_cat_id = ec.parent_id " +
            " INNER JOIN em_product_feature_values AS epfv " +
            " ON epfv.prod_feature_id = epfn.id AND epfv.product_id = ep.id " +
            " LEFT JOIN em_product_feature_category AS epfc " +
            " ON epfn.feature_category_id = epfc.id " +
            " WHERE ep.id = :productId", nativeQuery = true)
      *
      * */



    @Query(value =  " SELECT ep.*, " +
            " ec.id AS categoryId, ec.name, ec.search_result_name, ec.parent_id, ec.state, ec.is_vertical, ec.is_leaf, " +
            " eb.id AS brandId, eb.brand_name, eb.brand_display_name, " +
            " GROUP_CONCAT(epfn.prod_feature_name SEPARATOR '|') AS feature_names, " +
            " GROUP_CONCAT(epfn.is_key_feature SEPARATOR '|') AS key_feature_states, " +
            " GROUP_CONCAT(epfv.prod_feature_value SEPARATOR '|') AS feature_values, " +
            " GROUP_CONCAT(epfc.feature_category_name SEPARATOR '|') AS feature_category_names " +
            " FROM em_product AS ep " +
            " LEFT JOIN em_category AS ec ON ep.category_id = ec.id " +
            " LEFT JOIN em_brand AS eb ON ep.brand_id = eb.id " +

            " LEFT JOIN em_product_feature_names AS epfn ON epfn.prod_vert_id = ep.vertical_id AND epfn.is_key_feature = '1' " +
            " LEFT JOIN em_product_feature_values AS epfv ON epfv.prod_feature_id = epfn.id AND epfv.product_id = ep.id " +

            " LEFT JOIN em_product_feature_category AS epfc ON epfn.feature_category_id = epfc.id " +
            " WHERE ep.id IN :productIds " +
            "       AND ep.selling_rate BETWEEN :minPrice AND :maxPrice " +
            " GROUP BY ep.id ORDER BY ep.selling_rate ASC  LIMIT :limit OFFSET :startCount ",
            nativeQuery = true)
    Stream<ProductDetails> getProducts(@Param("productIds") List<Long> productIds,
                                       @Param("minPrice") int minPrice,
                                       @Param("maxPrice") int maxPrice,
                                       @Param("startCount") long startCount,
                                       @Param("limit") int limit);


    @Query(value =  " SELECT count(*) " +
            " FROM em_product AS ep " +
            " WHERE ep.id IN :productIds " +
            "   AND ep.selling_rate BETWEEN :minPrice AND :maxPrice ",
            nativeQuery = true)
    long getProductCount(@Param("productIds") List<Long> productIds,

                         @Param("minPrice") int minPrice,
                         @Param("maxPrice") int maxPrice);
}
