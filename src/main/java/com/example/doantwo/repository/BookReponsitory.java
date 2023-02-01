package com.example.doantwo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.doantwo.entity.BookEntity;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.google.common.base.Optional;

@Repository
public interface BookReponsitory extends JpaRepository<BookEntity,Long>{
    Page<BookEntity> findAll(Pageable pageable);
   
}
