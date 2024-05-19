package com.umsa.proyec_admin.services;

import java.util.List;
import java.util.Optional;

import com.umsa.proyec_admin.dtos.CreateUsuarioDto;
import com.umsa.proyec_admin.dtos.LoginDto;
import com.umsa.proyec_admin.dtos.UsuarioDto;




public interface IUsuario {

    List<UsuarioDto> findAllUsuario();

    Optional<UsuarioDto> findUsuarioById(Short id);

    UsuarioDto createUsuario(CreateUsuarioDto usuarioentiti);

    UsuarioDto updateUsuario(CreateUsuarioDto usuarioentiti, Short id);

    void deleteUsuario(Short id);

    UsuarioDto autentifiacion(LoginDto loginDto);


}
