package com.banana.comercial.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banana.comercial.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{

	Optional<Reserva> findBySalaAndLocalFilialAndDataHoraInicialAndDataHoraFinal(int sala, String localFilial, String dataHoraInicial, String dataHoraFinal);
}
