package com.reserva.hotel.repository;

import com.reserva.hotel.model.ReservaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservaRepository extends JpaRepository<ReservaModel, Long> {

}
