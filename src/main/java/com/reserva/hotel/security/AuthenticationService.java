package com.reserva.hotel.security;

import com.reserva.hotel.Exception.CustomExceptions.UserJaCadastradoException;
import com.reserva.hotel.dto.AuthDTO.CadastroAuthDTO;
import com.reserva.hotel.dto.AuthDTO.CadastroResponseDTO;
import com.reserva.hotel.dto.AuthDTO.LoginAuthDTO;
import com.reserva.hotel.dto.AuthDTO.TokenDTO;
import com.reserva.hotel.model.User;
import com.reserva.hotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public TokenDTO login(LoginAuthDTO dto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.email(), dto.senha()
                )
        );
        User user = (User) authentication.getPrincipal();
        String token = tokenService.generateToken(user);
        return new TokenDTO(token);
    }

    public CadastroResponseDTO cadastro (CadastroAuthDTO dto){
        if(userRepository.existsByEmail(dto.email())){
            throw new UserJaCadastradoException("Este usuário já foi cadastrado.");
        }

        User user = new User();
        user.setNome(dto.nome());
        user.setEmail(dto.email());
        user.setSenha(passwordEncoder.encode(dto.senha()));
        user.setRole(dto.role());

        User usuarioSalvo = userRepository.save(user);
        return new CadastroResponseDTO(usuarioSalvo.getId(),
                usuarioSalvo.getNome(), usuarioSalvo.getEmail(), usuarioSalvo.getRole());
    }
}
