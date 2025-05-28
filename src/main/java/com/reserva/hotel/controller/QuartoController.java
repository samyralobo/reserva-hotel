package com.reserva.hotel.controller;

import com.reserva.hotel.model.QuartoModel;
import com.reserva.hotel.service.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quartos")
public class QuartoController {
    @Autowired
    private QuartoService quartoService;

    @PostMapping("/listar-quartos")
    public QuartoModel adicionarQuarto(@RequestBody QuartoModel quarto){
        return quartoService.adicionarQuarto(quarto);
    }


    @GetMapping("/listar-quartos")
    public List<QuartoModel> listarQuartos(){
        return quartoService.listarQuartos();
    }
}
