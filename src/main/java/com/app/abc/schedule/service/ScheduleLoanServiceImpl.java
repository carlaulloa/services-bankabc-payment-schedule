package com.app.abc.schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.abc.schedule.model.entity.ScheduleLoan;
import com.app.abc.schedule.model.repository.ScheduleLoanRepository;

@Service
public class ScheduleLoanServiceImpl implements IScheduleLoanService {

	private @Autowired ScheduleLoanRepository scheduleLoanRepository;

	@Override
	@Transactional
	public ScheduleLoan save(ScheduleLoan scheduleLoan) {
		return this.scheduleLoanRepository.save(scheduleLoan);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ScheduleLoan> findAll() {
		return (List<ScheduleLoan>) this.scheduleLoanRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<ScheduleLoan> findByNroPrestamo(Integer nroPrestamo) {
		return (List<ScheduleLoan>) this.scheduleLoanRepository.findByNroPrestamo(nroPrestamo);
	}

	@Override
	@Transactional(readOnly = true)
	public ScheduleLoan findByNroPrestamoAndCuota(Integer nroPrestamo, Integer cuota) {
		return this.scheduleLoanRepository.findByNroPrestamoAndCuota(nroPrestamo, cuota).orElse(null);
	}

}
