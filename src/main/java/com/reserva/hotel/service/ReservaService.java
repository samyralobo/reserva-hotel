package com.reserva.hotel.service;

import com.reserva.hotel.model.HotelModel;
import com.reserva.hotel.model.QuartoModel;
import com.reserva.hotel.model.ReservaModel;
import com.reserva.hotel.repository.HotelRepository;
import com.reserva.hotel.repository.QuartoRepository;
import com.reserva.hotel.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    public ReservaModel reservarQuarto(Long id_quarto, Long id_hotel, ReservaModel reserva){

        Optional<HotelModel> hotel = hotelRepository.findById(id_hotel);
        if (hotel.isPresent()){
            Optional<QuartoModel> quarto = quartoRepository.findById(id_quarto);

            if (quarto.isPresent()){
                reserva.setQuarto(quarto);
            }else {
                System.out.println("ERRO! Quarto indisponível!");
            }

        }else {
            System.out.println("ERRO! Hotel não encontrado.");
        }

        return reservaRepository.save(reserva);
    }

    public List<ReservaModel> listarReservas(){
        return reservaRepository.findAll();
    }
}
