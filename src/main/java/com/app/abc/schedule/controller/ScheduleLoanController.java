package com.app.abc.schedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.abc.schedule.model.entity.ScheduleLoan;
import com.app.abc.schedule.service.IScheduleLoanService;

@RestController
public class ScheduleLoanController {

	private @Autowired IScheduleLoanService scheduleLoanService;
	
	@GetMapping("/v1/payment-schedules")
	public List<ScheduleLoan> findAll(){
		return this.scheduleLoanService.findAll();
	}
	
	@GetMapping("/v1/payment-schedules/{nroPrestamo}")
	public List<ScheduleLoan> findByNroPrestamo(@PathVariable Integer nroPrestamo){
		return this.scheduleLoanService.findByNroPrestamo(nroPrestamo);
	}
}
