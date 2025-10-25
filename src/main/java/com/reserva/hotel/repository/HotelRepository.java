package com.reserva.hotel.repository;

import com.reserva.hotel.model.HotelModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HotelRepository extends JpaRepository<HotelModel, Long> {
    Optional<HotelModel> findByNomeHotel(String s);

   Optional<List<HotelModel>> findByQuartos(HotelModel hotel);
}
