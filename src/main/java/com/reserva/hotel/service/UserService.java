package com.reserva.hotel.service;

import com.reserva.hotel.Exception.CustomExceptions.UserJaCadastradoException;
import com.reserva.hotel.Exception.CustomExceptions.UsuarioNaoEncontradoException;
import com.reserva.hotel.dto.ResponseDTO.BuscarUserPorIdDTO;
import com.reserva.hotel.dto.RequestDTO.CriarUsuarioDTO;
import com.reserva.hotel.dto.ResponseDTO.ListarUsuariosDTO;
import com.reserva.hotel.dto.RequestDTO.UpdateUserDTO;
import com.reserva.hotel.model.User;
import com.reserva.hotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CriarUsuarioDTO criarUsuario(CriarUsuarioDTO dto){
       userRepository.findByEmail(dto.email()).ifPresent(user -> {
       throw new UserJaCadastradoException("Usuário já cadastrado.");
       });

       User userEntity = new User();
       userEntity.setEmail(dto.email());
       userEntity.setNome(dto.nome());
       userEntity.setSenha(passwordEncoder.encode(dto.senha()));
       userEntity.setRole(dto.role());

       userRepository.save(userEntity);
       return dto;
    }

    public List<ListarUsuariosDTO> listarUsuarios(){
        List<User> user = userRepository.findAll();

        return user.stream().map(userListagem -> new ListarUsuariosDTO(
                userListagem.getId(), userListagem.getNome(), userListagem.getEmail(),
                userListagem.getRole()
        )).toList();
    }

    public BuscarUserPorIdDTO buscarUserPorId(Long id){
        User user = userRepository.findById(id).orElseThrow(
                ()-> new UsuarioNaoEncontradoException("Usuário não encontrado."));

        return new BuscarUserPorIdDTO(user.getId(), user.getNome(), user.getEmail(),
                user.getSenha(), user.getRole());
    }

    public void updateUser(Long id, UpdateUserDTO dto){
        User user = userRepository.findById(id).orElseThrow(
                ()-> new UsuarioNaoEncontradoException("Usuário não encontrado."));

        user.setNome(dto.nome());
        user.setEmail(dto.email());
        user.setSenha(passwordEncoder.encode(dto.senha()));
        user.setRole(dto.role());

        userRepository.save(user);
    }

    public void deletarUsuario(Long id){
        boolean user = userRepository.existsById(id);

        if (!user){
            throw new UsuarioNaoEncontradoException("Usuário não encontrado.");
        }

       userRepository.deleteById(id);
    }
}
