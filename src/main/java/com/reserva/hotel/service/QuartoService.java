package com.reserva.hotel.service;

import com.reserva.hotel.Exception.Exceptions.QuartoExistenteException;
import com.reserva.hotel.Exception.Exceptions.QuartoNaoExistnteException;
import com.reserva.hotel.dto.AdicionarQuartoDTO;
import com.reserva.hotel.dto.ListarQuartosDTO;
import com.reserva.hotel.dto.UpdateQuartoDTO;
import com.reserva.hotel.model.QuartoModel;
import com.reserva.hotel.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    public Stream<ListarQuartosDTO> listarQuartos(){
        List<QuartoModel> quartoEntity = quartoRepository.findAll();
        return quartoEntity.stream().map(quarto -> new ListarQuartosDTO(quarto.getId(), quarto.getNumero(),
                quarto.getDisponivel(), quarto.getHotel(), quarto.getReserva()));
    }

    public AdicionarQuartoDTO adicionarQuarto(AdicionarQuartoDTO adicionarQuartoDTO){
        QuartoModel quarto = quartoRepository.findByNumero(adicionarQuartoDTO.numero());

        if (quarto != null){
            throw new QuartoExistenteException("Quarto já cadastrado");
        }

        quarto.setId(adicionarQuartoDTO.id());
        quarto.setNumero(adicionarQuartoDTO.numero());
        quarto.setHotel(adicionarQuartoDTO.hotel());
        quarto.setDisponivel(adicionarQuartoDTO.disponivel());
        quarto.setReserva(adicionarQuartoDTO.reserva());

        return adicionarQuartoDTO;
    }

    public void deletarQuarto(Long id){
        Optional<QuartoModel> quartoId = quartoRepository.findById(id);

        if (quartoId.isEmpty()){
            throw new QuartoNaoExistnteException("Quarto não encontrado.");
        }

        QuartoModel quartoEntity = new QuartoModel();
        quartoEntity.setId(quartoId.get().getId());
        quartoRepository.delete(quartoEntity);
    }

    public void updateQuarto(Long id, UpdateQuartoDTO updateQuartoDTO){
        QuartoModel quarto = quartoRepository.findById(id).orElseThrow(() ->
                new QuartoNaoExistnteException("Quarto não encontrado"));

        quarto.setId(updateQuartoDTO.id());
        quarto.setNumero(updateQuartoDTO.numero());
        quarto.setDisponivel(updateQuartoDTO.disponivel());
        quarto.setHotel(updateQuartoDTO.hotel());
        quarto.setReserva(updateQuartoDTO.reserva());
    }


}
