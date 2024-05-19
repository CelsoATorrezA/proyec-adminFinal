package com.umsa.proyec_admin.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PuestoEntity {

    @Id
    @Column(name = "puesto_id")
    private Short id;
    @Column(name= "nombrepuesto_id")
    private String nombrePuesto;
}
