package com.reserva.hotel.service;

import com.reserva.hotel.Exception.CustomExceptions.HotelExistenteException;
import com.reserva.hotel.Exception.CustomExceptions.HotelNaoEncontradoException;
import com.reserva.hotel.dto.RequestDTO.CadastrarHotelDTO;
import com.reserva.hotel.dto.RequestDTO.UpdateHotelDTO;
import com.reserva.hotel.dto.ResponseDTO.GetHotelByIdDTO;
import com.reserva.hotel.dto.ResponseDTO.ListarHotelDTO;
import com.reserva.hotel.dto.ResponseDTO.QuartoDTO;
import com.reserva.hotel.model.HotelModel;
import com.reserva.hotel.repository.HotelRepository;
import com.reserva.hotel.repository.QuartoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    @Transactional
    public CadastrarHotelDTO cadastrarHotel(CadastrarHotelDTO dto){
        hotelRepository.findByNomeHotel(dto.nomeHotel())
                .ifPresent(hotel-> {throw new HotelExistenteException("Hotel já cadastrado");});

        HotelModel hotelEntity = new HotelModel();
        hotelEntity.setNomeHotel(dto.nomeHotel());
        hotelEntity.setEndereco(dto.endereco());

        hotelRepository.save(hotelEntity);
        return dto;
    }

    public List<ListarHotelDTO> listarHoteis(){
        List<HotelModel> hotelEntity = hotelRepository.findAll();

        return hotelEntity.stream().map(
                hotel ->
                        new ListarHotelDTO(hotel.getId(),
                        hotel.getNomeHotel(),
                        hotel.getEndereco())).collect(Collectors.toList());
    }

    public GetHotelByIdDTO getHotelById(Long id){
        HotelModel hotel = hotelRepository.findById(id)
                .orElseThrow(()-> new HotelNaoEncontradoException("Hotel não encontrado."));

        return new GetHotelByIdDTO(hotel.getNomeHotel(),
                hotel.getEndereco(),
                hotel.getQuartos()
                        .stream().map(quarto ->
                                new QuartoDTO( quarto.getId(),
                                        quarto.getNumero(), quarto.getDisponivel()))
                        .collect(Collectors.toList()));
    }

    @Transactional
    public void deletarHotel(Long id){
        HotelModel hotel = hotelRepository.findById(id)
                .orElseThrow(()-> new HotelNaoEncontradoException("Hotel não encontrado."));

        quartoRepository.deleteAllByHotel(hotel);

        hotelRepository.delete(hotel);
    }

    @Transactional
    public void updateHotel(Long id, UpdateHotelDTO dto){
        HotelModel hotel = hotelRepository.findById(id).orElseThrow(()
                -> new HotelNaoEncontradoException("Hotel não encontrado."));

        hotel.setNomeHotel(dto.nomeHotel());
        hotel.setEndereco(dto.endereco());

        hotelRepository.save(hotel);
    }
}
