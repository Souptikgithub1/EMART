package com.em.service;

import com.em.entity.Banner;
import com.em.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ANIMUS on 22-08-2017.
 */
@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerRepository bannerRepository;

    @Override
    @Transactional
    public List<Banner> getBanners() {
        return this.bannerRepository.findAll();
    }
}
