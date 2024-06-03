package com.umsa.proyec_admin.entities;

import org.hibernate.annotations.ForeignKey;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Getter
@Setter
@Entity
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    @Column(name = "usu_id")
    private Short id;
    @Column(name = "usu_nombre")
    private String nombreusu;
    @Column(name = "usu_password")
    private String password;


    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name ="rol_id", nullable = false)
    private RolEntity rol;
}
