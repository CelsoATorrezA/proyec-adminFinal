package com.umsa.proyec_admin.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umsa.proyec_admin.dtos.CreateUsuarioDto;
import com.umsa.proyec_admin.dtos.LoginDto;
import com.umsa.proyec_admin.dtos.UsuarioDto;
import com.umsa.proyec_admin.services.IUsuario;


@RequestMapping("/usuarios")
@RestController

public class UsuarioController {

    private final IUsuario usuarioservices;


    public UsuarioController(IUsuario usuarioservices){
        this.usuarioservices=usuarioservices;
    }

    @GetMapping()
        public List <UsuarioDto> findAllUsuarios(){
            return this.usuarioservices.findAllUsuario();
    }
    @GetMapping("/{id}")
        public Optional<UsuarioDto> findOneById(@PathVariable Short id){
            return this.usuarioservices.findUsuarioById(id);
        }
    @PostMapping()
        public UsuarioDto createUsuariodto(@RequestBody CreateUsuarioDto usuario){
            return this.usuarioservices.createUsuario(usuario);
        }
     @PutMapping("/{id}")
        public UsuarioDto updateUsuariodto(@RequestBody CreateUsuarioDto usuario, @PathVariable Short id){
            return this.usuarioservices.updateUsuario(usuario, id);
        }
    @DeleteMapping("/{id}")
        public void deleteUsuarioById(@PathVariable Short id){
            this.usuarioservices.deleteUsuario(id);
        }
 
    @PostMapping("/login")
public ResponseEntity<UsuarioDto> login(@RequestBody LoginDto loginDto) {
    UsuarioDto usuarioDto = usuarioservices.autentifiacion(loginDto);
    if (usuarioDto != null) {
        // Autenticación exitosa
        return ResponseEntity.ok(usuarioDto);
    } else {
        // Credenciales inválidas
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Unauthorized
    }
}
}
