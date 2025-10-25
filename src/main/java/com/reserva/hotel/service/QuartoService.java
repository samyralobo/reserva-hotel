package com.reserva.hotel.service;

import com.reserva.hotel.Exception.CustomExceptions.HotelNaoEncontradoException;
import com.reserva.hotel.Exception.CustomExceptions.QuartoJaCadastradoException;
import com.reserva.hotel.Exception.CustomExceptions.QuartoNaoExistnteException;
import com.reserva.hotel.dto.RequestDTO.AdicionarQuartoDTO;
import com.reserva.hotel.dto.ResponseDTO.ListarQuartosDTO;
import com.reserva.hotel.dto.RequestDTO.UpdateQuartoDTO;
import com.reserva.hotel.model.HotelModel;
import com.reserva.hotel.model.QuartoModel;
import com.reserva.hotel.repository.HotelRepository;
import com.reserva.hotel.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private HotelRepository hotelRepository;

    public AdicionarQuartoDTO adicionarQuarto(AdicionarQuartoDTO dto, Long hotelId){
        HotelModel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(()-> new HotelNaoEncontradoException("Hotel não encontrado"));

//        quartoRepository.findByNumeroAndHotelId(dto.numero(), hotelId).ifPresent(quarto ->
//        {throw new QuartoJaCadastradoException("Quarto já cadastrado no hotel");});

        QuartoModel quartoEntity = new QuartoModel();
        quartoEntity.setNumero(dto.numero());
        quartoEntity.setDisponivel(dto.disponivel());
        quartoEntity.setHotel(hotel);

        quartoRepository.save(quartoEntity);
        return dto;
    }

    public void deletarQuarto(Long quartoId, Long hotelId){
        HotelModel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(()-> new HotelNaoEncontradoException("Hotel não encontrado!"));

        boolean quartoExiste = quartoRepository.existsById(quartoId);

        if (!quartoExiste){
            throw new QuartoNaoExistnteException("Quarto não encontrado.");
        }

        quartoRepository.deleteById(quartoId);
    }

    public void updateQuarto(Long quartoId, Long hotelId, UpdateQuartoDTO updateQuartoDTO){
        HotelModel hotel = hotelRepository.findById(hotelId).orElseThrow(()->
                new HotelNaoEncontradoException("Hotel não encontrado"));

        QuartoModel quarto = quartoRepository.findById(quartoId).orElseThrow(() ->
                new QuartoNaoExistnteException("Quarto não encontrado"));

        quarto.setNumero(updateQuartoDTO.numero());
        quarto.setDisponivel(updateQuartoDTO.disponivel());
        quarto.setHotel(hotel);
        quarto.setReserva(updateQuartoDTO.reserva());

        quartoRepository.save(quarto);
    }

    public List<ListarQuartosDTO> listarQuartosNoHotel(Long id) {
        HotelModel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNaoEncontradoException("Hotel não encontrado"));

        List<QuartoModel> quartos = hotel.getQuartos();

        return quartos.stream().map(quarto-> new ListarQuartosDTO(
                quarto.getId(), quarto.getNumero(), quarto.getDisponivel()))
                .toList();
    }
}
