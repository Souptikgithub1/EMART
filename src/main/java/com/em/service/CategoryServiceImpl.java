package com.em.service;

import com.em.entity.Category;
import com.em.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ANIMUS on 04-09-2017.
 */
@Service("categoryServie")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    @Transactional
    public Category add(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    @Transactional
    public List<Category> getAll() {
        return this.categoryRepository.getAll();
    }

    @Override
    public List<Category> getVerticals() {
        return this.categoryRepository.getVerticals();
    }

    @Override
    public List<Category> getLeafs() {
        return this.categoryRepository.getLeafs();
    }

    @Override
    public List<Category> getLeafsByParentId(long parentId) {
        return this.categoryRepository.getCategoriesByParentId(parentId);
    }
}
