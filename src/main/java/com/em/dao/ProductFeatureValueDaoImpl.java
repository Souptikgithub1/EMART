package com.em.dao;

import com.em.entity.ProductFeatureValues;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Transactional
@Repository
public class ProductFeatureValueDaoImpl implements ProductFeatureValueDao {
    //SELECT * FROM `em_product_feature_values` WHERE
    //      product_id IN (SELECT product_id from em_product_feature_values WHERE prod_feature_value IN ('2 GB') AND prod_feature_id = 21)
    // AND  product_id IN (SELECT product_id from em_product_feature_values WHERE prod_feature_value IN ('16 GB') AND prod_feature_id = 20) GROUP BY `product_id`


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Long> getProductIdsByFilter(List<Map<String, Object>> filters) {

        String whereClause = " 0 ";

        if(filters.size() > 0){
            whereClause = " ";
            for (Map<String, Object> filter: filters) {
                long featureId = (long) Double.parseDouble(filter.get("featureId").toString());
                List<String> featureValueList = (List<String>) (List<?>) filter.get("filterValues");
                String featureValues = "";
                for (String featureValue: featureValueList) {
                    featureValues += "'" + featureValue + "',";
                }
                featureValues = featureValues.substring(0, featureValues.length()-1);
                whereClause += " epfv.product_id IN (SELECT product_id from em_product_feature_values WHERE prod_feature_value IN (" + featureValues + ") AND prod_feature_id = " + featureId + ") AND ";
            }

            whereClause = whereClause.substring(0, whereClause.length()-4);
        }



        String query =  "SET SESSION sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY','')); " +
                        " SELECT *FROM em_product_feature_values AS epfv WHERE " + whereClause + " GROUP BY epfv.product_id";
        List<ProductFeatureValues> productFeatureValuesList = this.entityManager.createNativeQuery(query, ProductFeatureValues.class).getResultList();
        List<Long> productIds = new LinkedList<>();
        productFeatureValuesList.forEach(productFeatureValue -> productIds.add(productFeatureValue.getProductId()));
        return productIds;
    }
}
