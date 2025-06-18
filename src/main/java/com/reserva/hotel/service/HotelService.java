package com.reserva.hotel.service;

import com.reserva.hotel.Exception.Exceptions.HotelExistenteException;
import com.reserva.hotel.Exception.Exceptions.HotelNaoEncontradoException;
import com.reserva.hotel.dto.CadastrarHotelDTO;
import com.reserva.hotel.dto.ListarHotelDTO;
import com.reserva.hotel.dto.UpdateHotelDTO;
import com.reserva.hotel.model.HotelModel;
import com.reserva.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;


    public CadastrarHotelDTO cadastrarHotel(CadastrarHotelDTO cadastrarHotelDTO){
        HotelModel hotel = hotelRepository.findByNomeHotel(cadastrarHotelDTO.nomeHotel());

        if (hotel != null){
            throw new HotelExistenteException("Hotel já cadastrado");
        }

        hotel.setId(cadastrarHotelDTO.id());
        hotel.setNomeHotel(cadastrarHotelDTO.nomeHotel());
        hotel.setEndereco(cadastrarHotelDTO.endereco());

        hotelRepository.save(hotel);
        return cadastrarHotelDTO;
    }


    public Stream<ListarHotelDTO> listarHoteis(){
        List<HotelModel> hotelEntity = hotelRepository.findAll();
        return hotelEntity.stream().map(hotel -> new ListarHotelDTO(hotel.getId(), hotel.getNomeHotel(),
                hotel.getEndereco()));
    }

    public void deletarHotel(Long id){
        Optional<HotelModel> hotel = hotelRepository.findById(id);

        if (hotel.isEmpty()){
            throw new HotelNaoEncontradoException("Hotel não encontrado");
        }

        HotelModel hotelModel = new HotelModel();
        hotelModel.setId(hotel.get().getId());
        hotelRepository.delete(hotelModel);
    }

    public void updateHotel(Long id, UpdateHotelDTO updateHotelDTO){
        HotelModel hotel = hotelRepository.findById(id).orElseThrow(()
                -> new HotelNaoEncontradoException("Hotel não encontrado"));

        hotel.setId(updateHotelDTO.id());
        hotel.setNomeHotel(updateHotelDTO.nomeHotel());
        hotel.setEndereco(updateHotelDTO.endereco());
        hotel.setQuartos(updateHotelDTO.quartos());
        hotel.setReservas(updateHotelDTO.reservas());

        hotelRepository.save(hotel);
    }
}
