package com.ttm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ttm.service.TrainTicketMachineService;

@SpringBootApplication
public class TrainTicketMachineApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(TrainTicketMachineApplication.class, args);
		TrainTicketMachineService trainTicketMachineService = (TrainTicketMachineService) applicationContext
				.getBean(TrainTicketMachineService.class);
		trainTicketMachineService.executeSearch();
	}

}
