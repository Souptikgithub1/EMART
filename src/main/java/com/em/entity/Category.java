package com.em.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by ANIMUS on 03-09-2017.
 */
@Entity
@Table(name = "em_category")
public class Category implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "search_result_name")
    private String searchResultName;
    @Column(name = "parent_id")
    private long parentId;
    @Column(name = "state")
    private String state;
    @Column(name = "is_vertical")
    private String isVertical;
    @Column(name = "is_leaf")
    private String isLeaf;

    public Category() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSearchResultName() {
        return searchResultName;
    }

    public void setSearchResultName(String searchResultName) {
        this.searchResultName = searchResultName;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIsVertical() {
        return isVertical;
    }

    public void setIsVertical(String isVertical) {
        this.isVertical = isVertical;
    }

    public String getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf;
    }
}
