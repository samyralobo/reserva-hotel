package com.reserva.hotel.service;

import com.reserva.hotel.Exception.Exceptions.HotelNaoEncontradoException;
import com.reserva.hotel.Exception.Exceptions.QuartoNaoExistnteException;
import com.reserva.hotel.dto.ListarReservasDTO;
import com.reserva.hotel.model.QuartoModel;
import com.reserva.hotel.model.ReservaModel;
import com.reserva.hotel.repository.HotelRepository;
import com.reserva.hotel.repository.QuartoRepository;
import com.reserva.hotel.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private QuartoRepository quartoRepository;


    public ReservaModel reservarQuarto(QuartoModel quarto, Long id_hotel){
        boolean hotel = hotelRepository.existsById(id_hotel);

        if (!hotel){
            throw new HotelNaoEncontradoException("Hotel não encontrado");
        }

        Optional<QuartoModel> quartoModelOptional = Optional.ofNullable((QuartoModel) quartoRepository.findByDisponivel(quarto.getDisponivel()).
                orElseThrow(() -> new QuartoNaoExistnteException("Quarto não encontrado")));

        QuartoModel quartoEntity = new QuartoModel();
        quartoEntity.setDisponivel(false);

        quartoRepository.save(quartoEntity);

        ReservaModel quartoReservado = new ReservaModel();
        quartoReservado.setQuarto(quartoEntity);

        return reservaRepository.save(quartoReservado);

    }

    public Stream<ListarReservasDTO> listarReservas(){
        List<ReservaModel> reservaModels = reservaRepository.findAll();
        return reservaModels.stream().map(reserva -> new ListarReservasDTO(reserva.getNomeCliente(),
                reserva.getDataEntrada(),reserva.getDataSaida(), reserva.getQuarto(), reserva.getHotel()));
    }
}
