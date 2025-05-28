package com.reserva.hotel.repository;

import com.reserva.hotel.model.ReservaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<ReservaModel, Long> {
}
