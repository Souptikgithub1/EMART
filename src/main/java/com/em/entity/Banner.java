package com.em.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ANIMUS on 22-08-2017.
 */
@Entity
@Table(name = "em_banner")
public class Banner implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "banner_image")
    private String bannerImage;

    public Banner() {
        super();
    }

    public Banner(String bannerImage) {
        this.bannerImage = bannerImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }
}
