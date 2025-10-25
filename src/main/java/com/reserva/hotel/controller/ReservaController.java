package com.reserva.hotel.controller;

import com.reserva.hotel.dto.ResponseDTO.ListarReservasDTO;
import com.reserva.hotel.dto.RequestDTO.ReservarQuartoDTO;
import com.reserva.hotel.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")

public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping("/{quartoId}/{userId}")
    public ResponseEntity<ReservarQuartoDTO> reservarQuarto(@RequestBody ReservarQuartoDTO dto,
                                                            @PathVariable("quartoId") Long quartoId,
                                                            @PathVariable("userId") Long userId){
        reservaService.reservarQuarto(dto, quartoId, userId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ListarReservasDTO>> listarReservas(@PathVariable("id") Long id){
        List<ListarReservasDTO> reservas = reservaService.listarReservas(id);
        return ResponseEntity.ok().body(reservas);
    }
}
