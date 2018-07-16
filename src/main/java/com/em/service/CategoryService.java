package com.em.service;

import com.em.entity.Category;

import java.util.List;

/**
 * Created by ANIMUS on 04-09-2017.
 */
public interface CategoryService {

    Category add(Category category);
    Category get(long id);
    List<Category> getAll();
    List<Category> getVerticals();
    List<Category> getLeafs();
    List<Category> getLeafsByParentId(long parentId);
}
