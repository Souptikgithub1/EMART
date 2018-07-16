package com.em.repository;

import com.em.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ANIMUS on 04-09-2017.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT * FROM em_category AS cat WHERE cat.state = '1' ", nativeQuery = true)
    List<Category> getAll();

    @Query(value = "SELECT * FROM em_category AS cat where cat.state = '1' AND cat.is_vertical = '1' ", nativeQuery = true)
    List<Category> getVerticals();

    @Query(value = "SELECT * FROM em_category AS cat WHERE cat.state = '1' AND cat.is_leaf = '1' ", nativeQuery = true)
    List<Category> getLeafs();

    List<Category> getCategoriesByParentId(long parentId);

    Category findById(long id);
}
