package com.reserva.hotel.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "TB_HOTEL")
public class HotelModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String nomeHotel;

    @Column(nullable = false, length = 50)
    private String endereco;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<QuartoModel> quartos = new ArrayList<>();

    @OneToMany(mappedBy = "hotel")
    private List<ReservaModel> reservas;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeHotel() {
        return nomeHotel;
    }

    public void setNomeHotel(String nomeHotel) {
        this.nomeHotel = nomeHotel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


}
