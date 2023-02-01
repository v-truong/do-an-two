package com.example.doantwo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.doantwo.entity.CategoryEntity;
@Repository
public interface CategoryReponsitory extends JpaRepository<CategoryEntity, Long>{
    CategoryEntity findOneByName(String Name);
}
