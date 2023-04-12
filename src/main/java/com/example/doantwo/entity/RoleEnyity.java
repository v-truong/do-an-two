package com.example.doantwo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.Role;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import lombok.Data;
@Data
@Entity
@Table(name = "Role")
public class RoleEnyity extends BaseEntity{
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     long Id;
    @Column(name = "rolename")
    private String roleName;
    @ManyToMany(mappedBy = "roles")
    List<AccountEntity> accounts =new ArrayList<>();

    
    
}
