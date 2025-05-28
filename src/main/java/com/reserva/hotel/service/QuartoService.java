package com.reserva.hotel.service;

import com.reserva.hotel.model.QuartoModel;
import com.reserva.hotel.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    public List<QuartoModel> listarQuartos(){
        return quartoRepository.findAll();
    }

    public QuartoModel adicionarQuarto(QuartoModel quarto){
        return quartoRepository.save(quarto);
    }
}
