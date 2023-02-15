package com.example.employee.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table(name = "company")
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comp_id")
    private Long id;

    @Column(name = "company_name")
    private String name;

    @OneToMany(mappedBy = "company")
    private Collection<Employee> employees;

}
