package com.reserva.hotel.controller;

import com.reserva.hotel.dto.CadastrarHotelDTO;
import com.reserva.hotel.dto.DeletarHotelDTO;
import com.reserva.hotel.dto.ListarHotelDTO;
import com.reserva.hotel.dto.UpdateHotelDTO;
import com.reserva.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/hoteis")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @PostMapping()
    public ResponseEntity<CadastrarHotelDTO> cadastrarHotel(@RequestBody CadastrarHotelDTO cadastrarHotelDTO){
        hotelService.cadastrarHotel(cadastrarHotelDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping()
    public ResponseEntity<Stream<ListarHotelDTO>> listarHoteis(){
        Stream<ListarHotelDTO> hotel = hotelService.listarHoteis();
        return ResponseEntity.ok().body(hotel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeletarHotelDTO> deletarHotel(@PathVariable("id") long id){
        hotelService.deletarHotel(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateHotelDTO> updateHotel(@PathVariable("id") Long id, @RequestBody UpdateHotelDTO hotelDTO){
        hotelService.updateHotel(id, hotelDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
