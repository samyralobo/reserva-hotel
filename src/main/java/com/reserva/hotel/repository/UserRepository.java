package com.reserva.hotel.repository;

import com.reserva.hotel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByEmail(String email);

    void deleteById(Long id);

    boolean existsByEmail(String email);
}