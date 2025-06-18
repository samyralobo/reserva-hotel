package com.reserva.hotel.controller;

import com.reserva.hotel.dto.ListarReservasDTO;
import com.reserva.hotel.model.QuartoModel;
import com.reserva.hotel.model.ReservaModel;
import com.reserva.hotel.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/reservas")

public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping()
    public ResponseEntity<ReservaModel> reservarQuarto(@RequestBody QuartoModel quarto, @RequestBody Long id_quarto){
        reservaService.reservarQuarto(quarto, id_quarto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping()
    public ResponseEntity<Stream<ListarReservasDTO>> listarReservas(){
        Stream<ListarReservasDTO> reservas = reservaService.listarReservas();
        return ResponseEntity.ok().body(reservas);
    }
}
