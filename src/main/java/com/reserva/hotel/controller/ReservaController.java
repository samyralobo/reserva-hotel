package com.reserva.hotel.controller;

import com.reserva.hotel.model.HotelModel;
import com.reserva.hotel.model.QuartoModel;
import com.reserva.hotel.model.ReservaModel;
import com.reserva.hotel.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")

public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping("/reservar")
    public ReservaModel reservar(QuartoModel quarto,HotelModel hotel, @RequestBody ReservaModel reserva){
        return reservaService.reservarQuarto(quarto.getId(), hotel.getId(), reserva);
    }

    @GetMapping("/listar-reservas")
    public List<ReservaModel> listarReservas(){
        return reservaService.listarReservas();
    }
}
