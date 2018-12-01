package com.em.dao;

import com.em.bean.QueryLimit;
import com.em.bean.QueryOrder;
import com.em.bean.QuerySearchKeys;
import com.em.entity.ProductDetails;
import com.em.entity.SearchResult;

import java.util.List;

public interface ProductDetailsDao {
    SearchResult getSearchResult(QuerySearchKeys querySearchKeys, QueryOrder queryOrder, QueryLimit queryLimit);
    List<Long> getProductIdsByQueryString(List<String> queryStringArr);
}
