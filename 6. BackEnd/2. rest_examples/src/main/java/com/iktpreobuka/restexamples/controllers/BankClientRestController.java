package com.iktpreobuka.restexamples.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.restexamples.entities.BankClientEntity;

@RestController
@RequestMapping("/bankclients")
public class BankClientRestController {

	private static final Map<String, String> dictionary = Map.of(
			"gospodar", "lord",
			"prsten", "ring",
			"pivo", "beer"
			);

	@RequestMapping(method = RequestMethod.GET)
	public List<BankClientEntity> getAll() {
		List<BankClientEntity> clients = new ArrayList<BankClientEntity>();

		clients.add(new BankClientEntity(1, "Frodo", "Baggins", "frodo.ringbearer@gmail.com", 33, "Hobbiton"));
		clients.add(new BankClientEntity(2, "Samwise", "Gamgee", "gardeneroftheshire@gmail.com", 38, "Hobbiton"));

		return clients;

	}

	/*
	@RequestMapping(method = RequestMethod.GET, value = "/{clientId}")
	public BankClientEntity getByID(@PathVariable String clientId) {
		if(clientId.equals("1")) {
			return new BankClientEntity(1, "Frodo", "Baggins", "frodo.ringbearer@gmail.com");
		} else if(clientId.equals("2")) {
			return new BankClientEntity(2, "Samwise", "Gamgee", "gardeneroftheshire@gmail.com");
		} else {
			return new BankClientEntity();
		}
	}
	 */

	protected List<BankClientEntity> getDB() {
		List<BankClientEntity> clients = new ArrayList<BankClientEntity>();

		clients.add(new BankClientEntity(1, "Frodo", "Baggins", "frodo.ringbearer@gmail.com", 33, "Hobbiton"));
		clients.add(new BankClientEntity(2, "Samwise", "Gamgee", "gardeneroftheshire@gmail.com", 38, "Hobbiton"));
		clients.add(new BankClientEntity(3, "Meriadoc", "Brandybuck", "mischiefmaker@buckleberry.com", 37, "Buckland"));
		clients.add(new BankClientEntity(4, "Peregrin", "Took", "curioushobbit@foolofatook.com", 29, "Tookland"));
		clients.add(new BankClientEntity(5, "Gimli", "son of Glóin", "axebeard@dwarvenforge.com", 139, "Erebor"));
		clients.add(new BankClientEntity(6, "Legolas", null, "arrowmaster@woodlandrealm.com", 500, "Erebor"));

		return clients;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{clientId}")
	public BankClientEntity getById(@PathVariable String clientId) {
		for(BankClientEntity bce : getDB()) {
			if(bce.getId() == Integer.parseInt(clientId)) {
				return bce;
			}

		}
		return new BankClientEntity();	
	}

	@RequestMapping(method = RequestMethod.POST)
	public String add(@RequestBody BankClientEntity client) {
		System.out.println(client.getName().concat(" ").concat(client.getSurname()));

		return "New client added";
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{clientId}")
	public BankClientEntity modify(@PathVariable String clientId,
			@RequestBody BankClientEntity client) {
		BankClientEntity bce = new BankClientEntity(1, "Frodo", "Baggins", "frodo.ringbearer@gmail.com", 33, "Hobbiton");

		if(clientId.equals("1")) {
			bce.setName(client.getName());
			bce.setEmail(client.getEmail());
			return bce;
		} else {
			return null;
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{clientId}")
	public BankClientEntity delete(@PathVariable String clientId) {
		for(BankClientEntity bce : getDB()) {
			if(bce.getId() == Integer.parseInt(clientId)) {
				getDB().remove(bce);
				return bce;
			}
		}

		return new BankClientEntity();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/client")
	public BankClientEntity getByNameSurname(@RequestParam("name") String
			name, @RequestParam("surname") String surname) {
		if(name.equals("Frodo") && surname.equals("Baggins")) {
			return new BankClientEntity(1, "Frodo", "Baggins", "frodo.ringbearer@gmail.com", 33, "Hobbiton");
		} 
		return null;
	}

	/* 1.1 endpoint koji iz liste klijenata banke uzima samo email adrese
		svih klijenata i vraća listu email adresa*/

	@RequestMapping(method = RequestMethod.GET, value = "/emails")
	public List<String> getEmails() {
		List<String> emails = new ArrayList<>();

		for (BankClientEntity bce : getDB()) {
			emails.add(bce.getEmail());
		}

		return emails;
	}

	/* 1.2 endpoint koji vraća listu koja sadrži imena klijenata, čije ime
		počinje na slovo koje je prosleđeno kao parametar*/

	@RequestMapping(method = RequestMethod.GET, value = "/clients/{firstLetter}")
	public List<String> getNamesByFirstLetter(@PathVariable String firstLetter) {
		List<String> names = new ArrayList<>();

		List<BankClientEntity> clients = getDB();

		for (BankClientEntity bce : clients) {
			String name = bce.getName();

			if(name.startsWith(firstLetter)) {
				names.add(name);
			}
		}

		return names;
	}

	/* 1.3 endpoint koji vraća listu koja sadrži imena i prezimena klijenata,
		čije ime počinje na slovo koje je prosleđeno kao parametar i čije
		prezime počinje na slovo koje je prosleđeno kao parametar*/

	@RequestMapping(method = RequestMethod.GET, value = "/clients/firstLetters")
	public List<String> getClientsByFirstLetters(
			@RequestParam("firstLetterName") String firstLetterName,
			@RequestParam("firstLetterSurname") String firstLetterSurname) {
		List<String> namesAndSurnames = new ArrayList<>();

		for (BankClientEntity bce : getDB()) {

			if(bce.getName().startsWith(firstLetterName) && bce.getSurname().startsWith(firstLetterSurname)) {
				namesAndSurnames.add(bce.getName().concat(" ").concat(bce.getSurname()));
			}
		}

		return namesAndSurnames;
	}

	/* 1.4 endpoint koji vraća listu koja sadrži imena klijenata, koja su
	sortirana u redosledu koji je prosleđen kao parameter*/

	@RequestMapping(method = RequestMethod.GET, value = "/clients/sort/{order}")
	public List<String> sortClientNamesByInput(@PathVariable String order) {
		List<String> namesInOrder = new ArrayList<>();

		List<BankClientEntity> clients = getDB();

		if ("asc".equalsIgnoreCase(order)) {
			clients.sort(Comparator.comparing(BankClientEntity::getName));
		} else if ("desc".equalsIgnoreCase(order)) {
			clients.sort(Comparator.comparing(BankClientEntity::getName).reversed());
		} else {
			return null;
		}

		for(BankClientEntity client : clients) {
			namesInOrder.add(client.getName());
		}

		return namesInOrder;
	}

	/*2.1 endpoint koji u listi klijenata banke, svakom klijentu, postavlja
		polje bonitet na ‘P’ (pozitivan) ako je klijent mlađi od 65 godina ili ‘N’
		negativan ako je klijent stariji od 65 godina*/

	@RequestMapping(method = RequestMethod.PUT, value = "/bonitet")
	public String calcCrediRating() {
		List<BankClientEntity> clients = getDB();

		for(BankClientEntity client : clients) {
			if(client.getAge() >= 65) {
				String creditRating = "N";
				client.setCreditRating(creditRating);
			} else if(client.getAge() < 65 && client.getAge() > 18) {
				String creditRating = "P";
				client.setCreditRating(creditRating);
			} else {
				return "Ineligible client";
			}
		}
		return "Credit ratings Added/Updated";
	}

	/*2.2 endpoint koji briše klijenta iz liste klijenta ukoliko klijent nema
		jednu od vrednosti: ime, prezime, email*/

	@RequestMapping(method = RequestMethod.DELETE, value = "/clients/delete")
	public String deleteClientWithNull() {
		List<BankClientEntity> clients = getDB();
		List<BankClientEntity> clientsToDelete = new ArrayList<>();

		for (BankClientEntity client : clients) {
			if (client.getName() == null || client.getSurname() == null || client.getEmail() == null) {
				clientsToDelete.add(client);
			}
		}

		clients.removeAll(clientsToDelete);

		if (!clientsToDelete.isEmpty()) {
			return "Client with missing info deleted";
		} else {
			return "No clients with missing info found";
		}
	}

	/*2.3 endpoint koji vraća ukupan broj klijenata u listi klijenata koji
		imaju manje od broja godina koje je prosleđeno kao parametar*/

	@RequestMapping(method = RequestMethod.GET, value = "clients/countLess/{years}")
	public int countLessYears(@PathVariable String years) {
		List<BankClientEntity> clients = getDB();
		int count = 0;

		for(BankClientEntity client : clients) {
			if(client.getAge() < Integer.parseInt(years)) {
				count++;
			}
		}

		return count;
	}

	/* 2.4 endpoint koji prosečan broj godina klijenata iz liste klijenata*/

	@RequestMapping(method = RequestMethod.GET, value = "/clients/averageYears")
	public double averageAge() {
		List<BankClientEntity> clients = getDB();
		double avgAge = 0;

		for(BankClientEntity client : clients) {
			avgAge += client.getAge();
		}

		return avgAge / clients.size();
	}

	/* 3.1 endpoint koji omogućuje izmenu mesta stanovanja klijenta*/

	@RequestMapping(method = RequestMethod.PUT, value = "/clients/changelocation/{clientId}")
	public String changeLocation(@PathVariable int clientId, @RequestParam String location) {
		List<BankClientEntity> clients = getDB();

		for (BankClientEntity client : clients) {
			if (client.getId() == clientId) {
				client.setAddress(location);
				return "Client's (ID " + clientId + ") location changed to: " + location;
			}
		}

		return "Client with ID " + clientId + " not found";
	}

	/* 3.2 endpoint koji vraća klijente banke koji žive u gradu koji je
		prosleđen kao parametar*/

	@RequestMapping(method = RequestMethod.GET, value = "/clients/from/{city}")
	public List<BankClientEntity> getFromCity(@PathVariable String city) {
		List<BankClientEntity> clients = getDB();
		List<BankClientEntity> fromCity = new ArrayList<>();

		for (BankClientEntity client : clients) {
			if (city.equals(client.getAddress())) {

				fromCity.add(client);
			}
		}

		return fromCity;
	}

	/* 3.3 endpoint koji vraća klijente banke koji žive u gradu koji je
		prosleđen kao parametar i čiji je broj godina ispod broja
		prosleđenog kao drugi parametar*/

	@RequestMapping(method = RequestMethod.GET, value = "/clients/from/findByCityAndAge")
	public List<BankClientEntity> findByCityAndAge(
			@RequestParam String city,
			@RequestParam int age) {

		List<BankClientEntity> clients = getDB();
		List<BankClientEntity> byCityAndAge = new ArrayList<>();

		for (BankClientEntity client : clients) {
			if (city.equals(client.getAddress()) && age > client.getAge()) {

				byCityAndAge.add(client);
			}
		}

		return byCityAndAge;
	}

	/* 4.1 endpoint koji vraća „Hello yourName!“, gde yourName
		prosleđeno kao parametar*/

	@RequestMapping(method = RequestMethod.GET, value = "/greetings/{name}")
	public String greet(@PathVariable String name) {

		return "<html><h2>Hello " + name + "!</h2></html>";
	}

	/* 4.2 endpoint koji vraća sumu prvih n brojeva*/

	@RequestMapping("/sumaniza/{n}")
	public int sumNums(@PathVariable int n) {
		int sum = 0;

		for (int i = 0; i <= n; i++) {
			sum += i;
		}

		return sum;
	}
	
	/* 4.3 endpoint koji predstavlja englesko-srpski rečnik i koji za reč na
		srpskom vrati odgovarajući prevod na engleski jezik*/

	@RequestMapping("/recnik/{word}")
	public String translate(@PathVariable String word) {
		String wordInEng = dictionary.get(word);

		if (wordInEng != null) {
			return wordInEng;
		} else {
			return "Reč '" + word + "' ne postoji u rečniku.";
		}
	}
}
