package com.reserva.hotel.controller;

import com.reserva.hotel.dto.*;
import com.reserva.hotel.service.QuartoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/quartos")
public class QuartoController {
    @Autowired
    private QuartoService quartoService;

    @GetMapping()
    public ResponseEntity<Stream<ListarQuartosDTO>> listarQuartos() {
        Stream<ListarQuartosDTO> listagem = quartoService.listarQuartos();
        return ResponseEntity.ok().body(listagem);
    }

    @PostMapping()
    public ResponseEntity<AdicionarQuartoDTO> adicionarQuarto (@RequestBody AdicionarQuartoDTO adicionarQuartoDTO){
        quartoService.adicionarQuarto(adicionarQuartoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeletarQuartoDTO> deletarQuarto(@PathVariable("id") Long id){
        quartoService.deletarQuarto(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping()
    public ResponseEntity<UpdateQuartoDTO> updateQuarto(@PathVariable("id") Long id, @RequestBody UpdateQuartoDTO updateQuartoDTO){
        quartoService.updateQuarto(id, updateQuartoDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
