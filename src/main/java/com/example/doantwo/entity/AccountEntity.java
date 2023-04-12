package com.example.doantwo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "account")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity extends BaseEntity{
    // @Id
    // @GeneratedValue(strategy =GenerationType.IDENTITY)
    // private long Id;
    @Column(name = "Name",nullable = false,length = 50)
    private String name;
    @Column(name="Address",nullable =  false,length = 100)
    private String Address;
    @Column(name="Account",nullable = false,length = 50)
    private String Account;
    @Column(name = "PassWord",nullable = false,length = 50)
    private String passWord;
    @Column(name="Thumbnail",length = 100)
    private String Thumbnail; 
    @Column(name="Status")
    private int Status;
    @ManyToMany
    @JoinTable(name="account_role",
                joinColumns=@JoinColumn(name="account_id"),
                inverseJoinColumns = @JoinColumn(name="role_id"))
    private List<RoleEnyity> roles=new ArrayList<>();


}
