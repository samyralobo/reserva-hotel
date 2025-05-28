package com.reserva.hotel.controller;

import com.reserva.hotel.model.HotelModel;
import com.reserva.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hoteis")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @PostMapping("/cadastro-hotel")
    public HotelModel cadastroHotel(@RequestBody HotelModel hotel){
        return hotelService.cadastrarHotel(hotel);
    }

    @GetMapping("/listagem-hoteis")
    public List<HotelModel> listarHoteis(){
        return hotelService.listarHoteis();
    }
}
