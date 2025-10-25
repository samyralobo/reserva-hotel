package com.reserva.hotel.service;

import com.reserva.hotel.Exception.CustomExceptions.QuartoNaoDisponivelException;
import com.reserva.hotel.Exception.CustomExceptions.QuartoNaoExistnteException;
import com.reserva.hotel.Exception.CustomExceptions.UsuarioNaoEncontradoException;
import com.reserva.hotel.dto.ResponseDTO.ListarReservasDTO;
import com.reserva.hotel.dto.RequestDTO.ReservarQuartoDTO;
import com.reserva.hotel.model.QuartoModel;
import com.reserva.hotel.model.ReservaModel;
import com.reserva.hotel.model.User;
import com.reserva.hotel.repository.QuartoRepository;
import com.reserva.hotel.repository.ReservaRepository;
import com.reserva.hotel.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public ReservarQuartoDTO reservarQuarto(ReservarQuartoDTO dto,
                                            long quartoId,
                                            long userId){
        QuartoModel quarto = quartoRepository.findById(quartoId)
                .orElseThrow(()-> new QuartoNaoExistnteException("Quarto não encontrado"));

        User user = userRepository.findById(userId)
                .orElseThrow(()-> new UsuarioNaoEncontradoException("Usuário não encontrado."));

        if(!quarto.getDisponivel()){
            throw new QuartoNaoDisponivelException("Quarto não disponível.");
        }

        ReservaModel reserva = new ReservaModel();
        quarto.setDisponivel(false);
        reserva.setDataEntrada(dto.dataEntrada());
        reserva.setDataSaida(dto.dataSaida());
        reserva.setUser(user);
        reserva.setQuarto(quarto);

        reservaRepository.save(reserva);
        return dto;
    }


    public List<ListarReservasDTO> listarReservas(Long id){
        QuartoModel quarto = quartoRepository.findById(id)
                .orElseThrow(()-> new QuartoNaoExistnteException("Quarto não encontrado."));

        List<ReservaModel> reserva = quarto.getReserva();

        return reserva.stream().map(reservas -> new ListarReservasDTO(
                reservas.getId(), reservas.getDataEntrada(), reservas.getDataSaida())).toList();
    }
}
