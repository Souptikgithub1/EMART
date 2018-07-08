package com.em.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ANIMUS on 24-08-2017.
 */
@Entity
@Table(name = "em_brand")
public class Brand {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "brand_name")
    private String brandName;
    @Column(name = "brand_display_name")
    private String brandDisplayName;

    public Brand() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandDisplayName() {
        return brandDisplayName;
    }

    public void setBrandDisplayName(String brandDisplayName) {
        this.brandDisplayName = brandDisplayName;
    }
}
