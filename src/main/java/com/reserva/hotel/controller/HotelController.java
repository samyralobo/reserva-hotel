package com.reserva.hotel.controller;

import com.reserva.hotel.dto.RequestDTO.CadastrarHotelDTO;
import com.reserva.hotel.dto.RequestDTO.DeletarHotelDTO;
import com.reserva.hotel.dto.RequestDTO.UpdateHotelDTO;
import com.reserva.hotel.dto.ResponseDTO.GetHotelByIdDTO;
import com.reserva.hotel.dto.ResponseDTO.ListarHotelDTO;
import com.reserva.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<ListarHotelDTO>> listarHoteis(){
        List<ListarHotelDTO> hotel = hotelService.listarHoteis();
        return ResponseEntity.ok().body(hotel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHotelById(@PathVariable("id") Long id){
        GetHotelByIdDTO hotel = hotelService.getHotelById(id);
        return ResponseEntity.ok().body(hotel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeletarHotelDTO> deletarHotel(@PathVariable("id") Long id){
        hotelService.deletarHotel(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateHotelDTO> updateHotel(@PathVariable("id") Long id,
                                                      @RequestBody UpdateHotelDTO hotelDTO){
        hotelService.updateHotel(id, hotelDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
