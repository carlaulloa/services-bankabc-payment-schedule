package com.app.abc.schedule.service;

import java.util.List;

import com.app.abc.schedule.model.entity.ScheduleLoan;

public interface IScheduleLoanService {

	ScheduleLoan save(ScheduleLoan scheduleLoan);
	
	List<ScheduleLoan> findAll();
	
	List<ScheduleLoan> findByNroPrestamo(Integer nroPrestamo);
	
	ScheduleLoan findByNroPrestamoAndCuota(Integer nroPrestamo, Integer cuota);
}
