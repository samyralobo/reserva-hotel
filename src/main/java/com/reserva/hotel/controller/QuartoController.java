package com.reserva.hotel.controller;

import com.reserva.hotel.dto.RequestDTO.AdicionarQuartoDTO;
import com.reserva.hotel.dto.RequestDTO.DeletarQuartoDTO;
import com.reserva.hotel.dto.RequestDTO.UpdateQuartoDTO;
import com.reserva.hotel.dto.ResponseDTO.ListarQuartosDTO;
import com.reserva.hotel.service.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quartos")
public class QuartoController {
    @Autowired
    private QuartoService quartoService;

    @GetMapping("/{id}")
    public ResponseEntity<List<ListarQuartosDTO>> listarQuartosNoHotel(@PathVariable("id") Long id) {
        List<ListarQuartosDTO> listar= quartoService.listarQuartosNoHotel(id);
        return ResponseEntity.ok().body(listar);
    }

    @PostMapping("/{id}")
    public ResponseEntity<AdicionarQuartoDTO> adicionarQuarto (@RequestBody AdicionarQuartoDTO dto,
                                                               @PathVariable("id") Long id){
        quartoService.adicionarQuarto(dto, id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{quartoId}/{hotelId}")
    public ResponseEntity<DeletarQuartoDTO> deletarQuarto(@PathVariable("quartoId") Long quartoId,
                                                          @PathVariable("hotelId") Long hotelId){
        quartoService.deletarQuarto(quartoId, hotelId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{quartoId}/{hotelId}")
    public ResponseEntity<UpdateQuartoDTO> updateQuarto(@PathVariable("quartoId") Long quartoId,
                                                        @PathVariable("hotelId") Long hotelId,
                                                        @RequestBody UpdateQuartoDTO dto){
        quartoService.updateQuarto(quartoId, hotelId, dto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
