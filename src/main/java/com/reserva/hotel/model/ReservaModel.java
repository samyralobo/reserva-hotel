package com.reserva.hotel.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_RESERVA")
public class ReservaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataEntrada;

    @Column(nullable = false)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataSaida;

    @ManyToOne
    @JoinColumn(name = "quarto_id")
    private QuartoModel quarto;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
