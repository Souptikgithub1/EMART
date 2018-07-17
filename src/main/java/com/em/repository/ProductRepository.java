package com.em.repository;

import com.em.entity.Category;
import com.em.entity.Product;
import com.em.entity.ProductDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by ANIMUS on 24-08-2017.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value =  " SELECT  pr.*, cat.*, slr.*,pg.* FROM em_product AS pr " +
                    " LEFT JOIN em_category AS cat ON pr.category_id = cat.id" +
                    " LEFT JOIN em_brand AS slr ON pr.brand_id = slr.id " +
                    " LEFT JOIN em_product_gallery AS pg ON pr.id = pg.prod_id WHERE pr.category_id = :categoryId AND pr.state = '1' ", nativeQuery = true)
    public List<Product> getProducts(@Param("categoryId") String categoryId);

    public List<Product> findByCategory(Category category, Pageable pageable);

    public Page<Product> findByCategoryIdAndState(long categoryId, String state, Pageable pageable);

    @Modifying
    @Query(value =  " UPDATE em_product SET state = CASE WHEN state = '1' THEN '0' ELSE '1' END WHERE id = :productId", nativeQuery = true)
    void updateProductState(@Param("productId") long productId);

    List<Product> findByCategory_Id(long categoryId);
    List<Product> findByVerticalId(long verticalId);
    List<Product> findByVerticalIdAndBrand_Id(long verticalId, long brandId);
    List<Product> findByCategory_IdAndBrand_Id(long categoryId, long brandId);
}
