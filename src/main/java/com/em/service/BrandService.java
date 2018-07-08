package com.em.service;

import com.em.entity.Brand;

import java.util.List;

public interface BrandService {
    Brand add(Brand brand);
    List<Brand> getAll();
}
