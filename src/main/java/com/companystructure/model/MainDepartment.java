package com.companystructure.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "main_department")
@Proxy(lazy = false)
public class MainDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_main_dep")
    private int idMaindep;

    @Column(name = "name_department")
    private String nameMainDep;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "mainDepartment",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Department> departmentList;
}
