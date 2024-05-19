package com.umsa.proyec_admin.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umsa.proyec_admin.dtos.CreateRolDto;
import com.umsa.proyec_admin.dtos.RolDto;
import com.umsa.proyec_admin.services.IRol;
@RestController
@RequestMapping("/rol")
public class RolController {
    private final IRol rolService;

    public RolController(IRol rolService) {
        this.rolService = rolService;
    }

    @GetMapping()
    public List<RolDto> findAllRoles(){
        return this.rolService.findAllRoles();
    }

    @GetMapping("/{id}")
    public Optional<RolDto> findOneById(@PathVariable Short id){
        return this.rolService.findRolById(id);
    }

    @PostMapping()
    public RolDto createRol(@RequestBody CreateRolDto rol){
        return this.rolService.createRol(rol);
    }

    @PutMapping("/{id}")
    public RolDto update(@RequestBody CreateRolDto rol, @PathVariable Short id){       
        return this.rolService.updateRol(rol, id);
    }

    @DeleteMapping("/{id}")
    public void deleteRolById(@PathVariable Short id){
        this.rolService.deleteRol(id);
    }
}
