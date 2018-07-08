package com.em.service;

import com.em.entity.Brand;
import com.em.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("brandService")
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Brand add(Brand brand) {
        return this.brandRepository.save(brand);
    }

    @Override
    public List<Brand> getAll() {
        return this.brandRepository.findAll();
    }
}
