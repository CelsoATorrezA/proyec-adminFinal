package com.umsa.proyec_admin.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Getter
@Setter
@Entity
public class RolEntity {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    @Column(name = "rol_id")
    private Short id;

    @Column(name = "rol_nombre")
    private String nombrerol;

    
}
