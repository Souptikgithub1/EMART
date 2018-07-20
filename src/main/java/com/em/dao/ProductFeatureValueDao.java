package com.em.dao;

import java.util.List;
import java.util.Map;

public interface ProductFeatureValueDao {
    List<Long> getProductIdsByFilter(List<Map<String, Object>> filters);
}
