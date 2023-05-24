package com.sap.training.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="scholar")
@Data
public class Scholar {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "full_name", nullable = false)
    private String full_name;

    @Column(name = "batch", nullable = false)
    private String batch;
    
    @Column(name = "manager")
    private String manager;

    @Column(name = "inumber", nullable = false)
    private String inumber;
}
