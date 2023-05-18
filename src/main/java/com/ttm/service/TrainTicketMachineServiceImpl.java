package com.ttm.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Service
public class TrainTicketMachineServiceImpl implements TrainTicketMachineService{
	
	private static final List<String> STATION_LIST = Arrays.asList("Abrantes", "Ademia", "Aguieira",
			"Baixa da Banheira", "Barcelos", "Barqueiros", "Cacia", "Cais do Sodre", "Caldas da rainha", "Fontela",
			"Francelos", "Fratel", "Gata", "Giesteira", "Granja", "Lamarosa", "Lapa", "Lapa do Lobo", "Macinhata",
			"Madalena", "Mafra", "Oeiras", "Oia", "Oleiros", "Paramos", "Parede", "Paredes", "Santa Iria",
			"Santa Margarida", "Santana Cartaxo", "Santarem");

	public void executeSearch() {
		header();
		
		final Scanner scanner = new Scanner(System.in);

		StringBuilder stationName = new StringBuilder();
		StringBuilder currentChar = new StringBuilder();
		
		List<String> filteredStationList = new ArrayList<>(); 

		while (true) {
			System.out.println();

			currentChar.append(scanner.nextLine());

			if (Strings.isNotEmpty(currentChar)) {
				stationName.append(currentChar.charAt(0));

				middleText(stationName);

				filteredStationList = STATION_LIST
				.stream()
				.filter(s -> s.toLowerCase().startsWith(stationName.toString().toLowerCase()))
				.collect(Collectors.toList());
				
				if(filteredStationList.isEmpty()) {
					stationName.setLength(0);
				} else {
					filteredStationList.forEach(System.out::println);
				}
				

				currentChar.setLength(0);
				addLines();
			}

			System.out.println("Type the next value:");
		}

	}
	
	private static void middleText(StringBuilder stationName) {
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("User input: " + stationName);
		System.out.println("Available stations:");
		System.out.println();
		
	}

	private static void addLines() {
		System.out.println("-----------------------------------------------------------------------");
		System.out.println();
		System.out.println();
		System.out.println();
	}

	private static void header() {
		System.out.println("=======================================================================");
		System.out.println(" 						TRAIN TICKET MACHINE						   ");
		System.out.println("=======================================================================");
		System.out.println("Type the station name:\n");
	}
}
