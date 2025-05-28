package com.reserva.hotel.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    public List<QuartoModel> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<QuartoModel> quartos) {
        this.quartos = quartos;
    }
}
