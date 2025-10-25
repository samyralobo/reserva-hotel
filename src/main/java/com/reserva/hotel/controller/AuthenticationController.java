package com.reserva.hotel.controller;

import com.reserva.hotel.dto.AuthDTO.CadastroAuthDTO;
import com.reserva.hotel.dto.AuthDTO.CadastroResponseDTO;
import com.reserva.hotel.dto.AuthDTO.LoginAuthDTO;
import com.reserva.hotel.dto.AuthDTO.TokenDTO;
import com.reserva.hotel.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginAuthDTO dto){
        try {
            TokenDTO token = authenticationService.login(dto);
            return ResponseEntity.ok(token);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/cadastro")
    public ResponseEntity<CadastroResponseDTO> cadastro(@RequestBody CadastroAuthDTO dto){
        authenticationService.cadastro(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
