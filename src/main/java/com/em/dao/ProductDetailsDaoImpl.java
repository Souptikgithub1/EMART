package com.em.dao;

import com.em.bean.ProductDetailsBean;
import com.em.bean.QueryLimit;
import com.em.bean.QueryOrder;
import com.em.bean.QuerySearchKeys;
import com.em.beanFactory.ProductDetailsBeanFactory;
import com.em.entity.ProductDetails;
import com.em.entity.SearchResult;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Transactional
@Repository
public class ProductDetailsDaoImpl implements ProductDetailsDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public SearchResult getSearchResult(QuerySearchKeys querySearchKeys, QueryOrder queryOrder, QueryLimit queryLimit) {

        long categoryId = querySearchKeys.getCategoryId();
        long verticalId = querySearchKeys.getVerticalId();

        List<Long> brandIdList = querySearchKeys.getBrandIds();
        String brandIds = "";
        if(brandIdList.size() > 0){

            for (Long brandId: brandIdList) {
                brandIds += brandId + ",";
            }
            brandIds = brandIds.substring(0, brandIds.length()-1);
        }


        System.out.println(querySearchKeys.getProductIds());
        Set<Long> productIdList = new HashSet<>(querySearchKeys.getProductIds());
        System.out.println(productIdList);
        String productIds = "";
        if(productIdList.size() > 0){

            for (Long productId: productIdList) {
                productIds += productId + ",";
            }
            productIds = productIds.substring(0, productIds.length()-1);
        }

        String whereClause = " 0 ";

        //search by categoryId
        if(categoryId != 0){
            whereClause = " ep.category_id = " + categoryId + " ";

            if(brandIdList.size() > 0){

                whereClause += " AND ep.brand_id IN " + brandIds + " ";
            }
        }

        //search by verticalId
        if(verticalId != 0){
            whereClause = " ep.vertical_id = " + verticalId;

            if(brandIdList.size() > 0){
                whereClause += " AND ep.brand_id IN " + brandIds + " ";
            }
        }

        //search by product Ids
        if(productIdList.size() > 0){
            if(categoryId != 0 || verticalId != 0 || brandIdList.size() != 0){
                whereClause += " AND ep.id IN (" + productIds + ") ";
            }else{
                whereClause = " ep.id IN (" + productIds + ") ";
            }

        }

        int minPrice = querySearchKeys.getMinPrice();
        int maxPrice = querySearchKeys.getMaxPrice();
        if(maxPrice > 0){
            whereClause += " AND ep.selling_rate BETWEEN " + minPrice + " AND " + maxPrice + " ";
        }

        String orderBy = " ";
        if(queryOrder.getOrderBy() == "price"){
            orderBy = " ep.selling_rate ";
        }


        String query = " SELECT ep.*, " +
                " ec.id AS categoryId, ec.name, ec.search_result_name, ec.parent_id, ec.state AS cat_state, ec.is_vertical, ec.is_leaf, " +
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
                " WHERE ep.state = '1' AND " + whereClause +
                " GROUP BY ep.id ORDER BY " + orderBy + " " + queryOrder.getOrderDirection() +
                " LIMIT " + queryLimit.getLimit() + " OFFSET " + queryLimit.getOffset() + " ";

        List<ProductDetails> productDetailsList = this.entityManager.createNativeQuery(query, ProductDetails.class).getResultList();
        List<ProductDetailsBean> productDetailsBeanList = new LinkedList<>();
        productDetailsList.forEach(productDetails -> productDetailsBeanList.add(ProductDetailsBeanFactory.convert(productDetails)));

        List<BigInteger> totalCountList = this.entityManager.createNativeQuery(" SELECT count(*) FROM em_product AS ep WHERE ep.state = '1' AND " + whereClause + " " ).getResultList();
        long totalCount = totalCountList.get(0).longValue();

        int startCount = queryLimit.getOffset();
        int endCount = startCount + productDetailsBeanList.size();

        SearchResult searchResult = new SearchResult();
        searchResult.setProductDetailsBeans(productDetailsBeanList);
        searchResult.setStartCount(startCount + 1);
        searchResult.setEndCount(endCount);
        searchResult.setTotalProductCount(totalCount);
        searchResult.setNoOfPages( (int)(totalCount/queryLimit.getLimit()) + 1);

        return searchResult;
    }
}
