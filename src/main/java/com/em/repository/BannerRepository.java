package com.em.repository;

import com.em.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by ANIMUS on 22-08-2017.
 */
@Repository
public interface BannerRepository extends JpaRepository<Banner, Serializable>{
}
