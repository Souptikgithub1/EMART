package com.em.beanFactory;

import com.em.bean.Feature;
import com.em.bean.ProductDetailsBean;
import com.em.entity.ProductDetails;
import org.springframework.beans.BeanUtils;

import java.util.*;

public class ProductDetailsBeanFactory {

    public static ProductDetailsBean convert(ProductDetails productDetails){
        ProductDetailsBean productDetailsBean = new ProductDetailsBean();
        /* First copy all properties*/
        BeanUtils.copyProperties(productDetails, productDetailsBean);

        /* Fetching featurenames and values with comma seperated values */
        String featureNames = productDetails.getFeatureNames();
        String keyFeatureStates = productDetails.getKeyFeatureStates();
        String featureValues = productDetails.getFeatureValues();
        String featureCategoryNames = productDetails.getFeatureCategoryNames();

       /*Checking whether featurenames and featurevalues are null */
        if(featureNames != null && featureValues != null){

            String featureNameArr[] = featureNames.split("\\|");
            String keyFeatureStateArr[] = keyFeatureStates.split("\\|");
            String featureValueArr[] = featureValues.split("\\|");
            String featureCategoryNameArr[] = featureCategoryNames.split("\\|");

            List<Feature> featureList = new LinkedList<>();
            for(int i = 0 ; i < featureNameArr.length ; i++){
                if(featureValueArr[i].trim().length() != 0){
                    featureList.add(new Feature(featureNameArr[i], keyFeatureStateArr[i], featureValueArr[i], featureCategoryNameArr[i]));
                }

            }

            productDetailsBean.setFeatureList(featureList);
        }


        return productDetailsBean;
    }
}
