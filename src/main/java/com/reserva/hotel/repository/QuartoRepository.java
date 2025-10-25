package com.reserva.hotel.repository;

import com.reserva.hotel.model.HotelModel;
import com.reserva.hotel.model.QuartoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuartoRepository extends JpaRepository<QuartoModel, Long> {

    Optional<QuartoModel> findByNumero(Long numero);
    Optional<QuartoModel> findByDisponivel(Boolean disponivel);

    void deleteAllByHotel(HotelModel hotel);


    Optional<Object> findByNumeroAndHotelId(Integer numero, Long hotelId);
}
