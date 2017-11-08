package com.companystructure.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "department")
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dep")
    private int idDeaprtment;

    @Column(name = "name_department")
    private String nameDepartment;

    @Column(name = "date_creation")
    private Date dateCreation;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "department",cascade = CascadeType.ALL)
    private List<Worker> workers;

    public int getIdDeaprtment() {
        return idDeaprtment;
    }

    public void setIdDeaprtment(int idDeaprtment) {
        this.idDeaprtment = idDeaprtment;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }
}
