package com.greatLearning.employeeService.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("unused")
@Entity
@Setter
@Getter
@ToString(exclude = "user")
@EqualsAndHashCode(of = "roleId")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="role_id")
    private int roleId;

    @Column(name="role_name")
    private String roleName;

   @ManyToOne
   @JoinColumn(name = "user_id_fk", nullable = false)
    private User user;
}

