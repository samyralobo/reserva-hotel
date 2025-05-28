package com.reserva.hotel.service;

import com.reserva.hotel.model.HotelModel;
import com.reserva.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelRepository repository;

    public HotelModel cadastrarHotel(HotelModel hotel){
        return repository.save(hotel);
    }

    public List<HotelModel> listarHoteis(){
        return repository.findAll();
    }
}
