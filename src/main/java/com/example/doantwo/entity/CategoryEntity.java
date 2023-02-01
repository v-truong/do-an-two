package com.example.doantwo.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter
@Data
@Table(name ="category")
public class CategoryEntity extends BaseEntity {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // long Id;
    @Column(name = "Name",nullable = false,length = 50)
    String name;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<BookEntity> books=new ArrayList<>();
    
}
