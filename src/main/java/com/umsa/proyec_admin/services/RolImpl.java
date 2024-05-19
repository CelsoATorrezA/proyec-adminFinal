package com.umsa.proyec_admin.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.umsa.proyec_admin.dtos.CreateRolDto;
import com.umsa.proyec_admin.dtos.RolDto;
import com.umsa.proyec_admin.entities.RolEntity;
import com.umsa.proyec_admin.repository.RolRepository;

@Service
public class RolImpl implements IRol {


     private final RolRepository rolRepository;

     public RolImpl(RolRepository rolRepository){
        this.rolRepository=rolRepository;
     }
     @Override
     public List<RolDto> findAllRoles() {
         List<RolEntity> roles=this.rolRepository.findAll();
         List<RolDto> rolesDto=new ArrayList<RolDto>();
         for (RolEntity rol : roles) {
            RolDto rolDto=new RolDto();
            rolDto.setId(rol.getId());
            rolDto.setNombrerol(rol.getNombrerol());
            rolesDto.add(rolDto);
         }
         return rolesDto;
     }
 
     @Override
     public Optional<RolDto> findRolById(Short id) {
         RolEntity rolEntity =this.rolRepository.findById(id).get();
         RolDto rolDto=new RolDto();
         if(rolEntity != null){
            rolDto.setId(rolEntity.getId());
            rolDto.setNombrerol(rolEntity.getNombrerol());
         }
         return Optional.of(rolDto);
     }
 
    @Override
    public RolDto createRol(CreateRolDto createrolEntity) {
        RolEntity rolEntity=new RolEntity();
        rolEntity.setNombrerol(createrolEntity.getNombrerol());
        rolEntity=this.rolRepository.save(rolEntity);
        RolDto rolDto=new RolDto();
        rolDto.setId(rolEntity.getId());
        rolDto.setNombrerol(rolEntity.getNombrerol());

        return rolDto;
    }
    @Override
    public RolDto updateRol(CreateRolDto updaterolEntity, Short id) {
        RolEntity rolEntity=this.rolRepository.findById(id).get();
        rolEntity.setNombrerol(updaterolEntity.getNombrerol());
        rolEntity=this.rolRepository.save(rolEntity);
        RolDto rolDto=new RolDto();
        rolDto.setId(rolEntity.getId());
        rolDto.setNombrerol(rolEntity.getNombrerol());
        return rolDto;
    }
    @Override
    public void deleteRol(Short id) {
       this.rolRepository.deleteById(id);
        
    }

    
    



}
