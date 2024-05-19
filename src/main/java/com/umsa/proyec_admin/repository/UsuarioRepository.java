package com.umsa.proyec_admin.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.umsa.proyec_admin.entities.UsuarioEntity;

public interface UsuarioRepository extends ListCrudRepository<UsuarioEntity, Short>{

    UsuarioEntity findByNombreusu(String nombreusu);

    



 
}
