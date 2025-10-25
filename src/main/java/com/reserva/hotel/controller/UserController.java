package com.reserva.hotel.controller;

import com.reserva.hotel.dto.ResponseDTO.BuscarUserPorIdDTO;
import com.reserva.hotel.dto.RequestDTO.CriarUsuarioDTO;
import com.reserva.hotel.dto.ResponseDTO.ListarUsuariosDTO;
import com.reserva.hotel.dto.RequestDTO.UpdateUserDTO;
import com.reserva.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<CriarUsuarioDTO> criarUsuario (@RequestBody CriarUsuarioDTO dto){
        userService.criarUsuario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<ListarUsuariosDTO>> listarUsuarios(){
        List<ListarUsuariosDTO> usuarios = userService.listarUsuarios();
        return ResponseEntity.ok().body(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuscarUserPorIdDTO> buscarUserPorId(@PathVariable("id") Long id){
        BuscarUserPorIdDTO usuario = userService.buscarUserPorId(id);
        return ResponseEntity.ok().body(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateUserDTO> updateUser(@PathVariable("id") Long id,
                                                    @RequestBody UpdateUserDTO dto){
        userService.updateUser(id, dto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable("id") Long id){
        userService.deletarUsuario(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
