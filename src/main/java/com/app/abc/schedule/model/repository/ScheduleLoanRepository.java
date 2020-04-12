package com.app.abc.schedule.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.abc.schedule.model.entity.ScheduleLoan;

@Repository
public interface ScheduleLoanRepository extends CrudRepository<ScheduleLoan, Integer> {

	@Query("SELECT tb FROM ScheduleLoan tb "
			+ "WHERE tb.nroPrestamo = :nroPrestamo")
	Iterable<ScheduleLoan> findByNroPrestamo(@Param("nroPrestamo") Integer nroPrestamo);
	
	@Query("SELECT tb FROM ScheduleLoan tb "
			+ "WHERE tb.nroPrestamo = :nroPrestamo "
			+ "AND tb.cuota = :cuota")
	Optional<ScheduleLoan> findByNroPrestamoAndCuota(@Param("nroPrestamo") Integer nroPrestamo, 
			@Param("cuota") Integer cuota);
}
