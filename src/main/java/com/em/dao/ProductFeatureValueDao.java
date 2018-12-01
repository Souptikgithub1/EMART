package com.em.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductFeatureValueDao {
    Set<Long> getProductIdsByFilter(List<Map<String, Object>> filters);
}
