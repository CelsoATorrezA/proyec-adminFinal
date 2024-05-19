package com.umsa.proyec_admin.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.umsa.proyec_admin.dtos.CreateUsuarioDto;
import com.umsa.proyec_admin.dtos.LoginDto;
import com.umsa.proyec_admin.dtos.UsuarioDto;
import com.umsa.proyec_admin.entities.UsuarioEntity;
import com.umsa.proyec_admin.repository.RolRepository;
import com.umsa.proyec_admin.repository.UsuarioRepository;

@Service
public class UsuarioImpl implements IUsuario {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    public UsuarioImpl(UsuarioRepository usuarioRepository , RolRepository rolRepository){
        this.usuarioRepository=usuarioRepository;
        this.rolRepository=rolRepository;
    }


    @Override
    public List<UsuarioDto> findAllUsuario() {
        List<UsuarioEntity> usuario=this.usuarioRepository.findAll();
        List<UsuarioDto> usuarioDto=new ArrayList<UsuarioDto>();
        for (UsuarioEntity usus : usuario) {
            UsuarioDto ususDto=new UsuarioDto();
            ususDto.setId(usus.getId());
            ususDto.setNombreusu(usus.getNombreusu());
            ususDto.setPassword(usus.getPassword());
            usuarioDto.add(ususDto);
            
        }
        return usuarioDto;
    }

    @Override
    public Optional<UsuarioDto> findUsuarioById(Short id) {
        UsuarioEntity usuarioEntity = this.usuarioRepository.findById(id).get();
        UsuarioDto usuarioDto= new UsuarioDto();
        if(usuarioEntity != null){
            usuarioDto.setId(usuarioEntity.getId());
            usuarioDto.setNombreusu(usuarioEntity.getNombreusu());
            usuarioDto.setPassword(usuarioEntity.getPassword());
        }
        return Optional.of(usuarioDto);
    }
    @Override
    public UsuarioDto createUsuario(CreateUsuarioDto createUsuarioDto) {
        UsuarioEntity usuarioEntity= new UsuarioEntity();
        usuarioEntity.setNombreusu(createUsuarioDto.getNombreusu());
        usuarioEntity.setPassword(createUsuarioDto.getPassword());

        usuarioEntity=this.usuarioRepository.save(usuarioEntity);
        UsuarioDto usuarioDto=new UsuarioDto();
        usuarioDto.setId(usuarioEntity.getId());
        usuarioDto.setNombreusu(usuarioEntity.getNombreusu());
        usuarioDto.setPassword(usuarioEntity.getPassword());
        return usuarioDto;
    }
    @Override
    public UsuarioDto updateUsuario(CreateUsuarioDto usuarioDto, Short id) {
        UsuarioEntity usuarioEntity= this.usuarioRepository.findById(id).get();
        usuarioEntity.setNombreusu(usuarioDto.getNombreusu());
        usuarioEntity.setPassword(usuarioDto.getPassword());

        UsuarioDto usuDto=new UsuarioDto();
        usuDto.setId(usuarioEntity.getId());
        usuDto.setNombreusu(usuarioEntity.getNombreusu());
        usuDto.setPassword(usuarioEntity.getPassword());


        return usuDto;
    }

    @Override
    public void deleteUsuario(Short id) {
        this.usuarioRepository.deleteById(id);
        
    }
    
 @Override
    public UsuarioDto autentifiacion(LoginDto loginDto) {
        
        UsuarioEntity usuario = usuarioRepository.findByNombreusu(loginDto.getNombre_usuarioLogin());

        if (usuario == null) {
            System.out.println("Usuario no encontrado");
            return null;
        }
        if (usuario.getPassword().equals(loginDto.getContraseña())) {
            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setId(usuario.getId());
            usuarioDto.setNombreusu(usuario.getNombreusu());
            // No es una buena práctica devolver la contraseña, considera removerla
            usuarioDto.setPassword(usuario.getPassword());
            usuarioDto.setNombrerol(usuario.getRol().getNombrerol());
            
            return usuarioDto;
        } else {
            return null;
        }

        /*if (usuario != null && usuario.getPassword().equals(loginDto.getContraseña())) {
            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setId(usuario.getId());
            usuarioDto.setNombreusu(usuario.getNombreusu());
            // No es una buena práctica devolver la contraseña, considera removerla
            usuarioDto.setPassword(usuario.getPassword());
            System.out.println("Datos Correctos!!!!!");
            
            return usuarioDto;
        } else {
            System.out.println("Error datos incorrectos!");
            return null;
        }*/
    }
    

    



}
