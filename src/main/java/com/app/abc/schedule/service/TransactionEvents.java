package com.app.abc.schedule.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.abc.schedule.model.entity.ScheduleLoan;
import com.app.abc.schedule.model.entity.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import brave.Tracer;

@Service
public class TransactionEvents {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionEvents.class);
	private @Autowired ObjectMapper objectMapper;
	private @Autowired IScheduleLoanService scheduleLoanService;
	private @Autowired Tracer tracer;
	
	public void processTransactionEvent(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, 
		JsonProcessingException {
		LOGGER.info("Process consumer record {}", consumerRecord);
		Transaction transaction = this.objectMapper.readValue(consumerRecord.value(), Transaction.class);
		this.tracer.currentSpan().tag("info", "Consumer record mapeado");
		LOGGER.info("Mapped transaction {}", transaction);
		ScheduleLoan scheduleLoan = this.scheduleLoanService.findByNroPrestamoAndCuota(transaction.getNroPrestamo(), 
				transaction.getCuota());
		if(scheduleLoan != null) {
			this.tracer.currentSpan().tag("info", "Cuota encontrada");
			LOGGER.info("Found {}", scheduleLoan);
			scheduleLoan.setPagado(true);
			this.scheduleLoanService.save(scheduleLoan);
			LOGGER.info("Persisted successfully schedule payment");
			this.tracer.currentSpan().tag("info", "Cuota actualizada correctamente.");
		} else {
			LOGGER.info("No encontrado.");
			this.tracer.currentSpan().tag("info", "Prestamo no encontrado");
		}
	}
}
