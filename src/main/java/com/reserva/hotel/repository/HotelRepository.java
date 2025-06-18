package com.reserva.hotel.repository;

import com.reserva.hotel.model.HotelModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<HotelModel, Long> {
    HotelModel findByNomeHotel(String s);
}
