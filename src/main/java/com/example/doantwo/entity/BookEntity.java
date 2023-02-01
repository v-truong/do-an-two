package com.example.doantwo.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Data
@Table(name ="book")
@Setter

public class BookEntity extends BaseEntity {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // long id;
    @Column(name = "Bookname",nullable = false,length = 50)
    private String name;
    @Column(name="Description",nullable = false,length=100)
    private String Description;
    @ManyToOne
    @JoinColumn(name = "category_Id")
    private CategoryEntity category;
    
}
