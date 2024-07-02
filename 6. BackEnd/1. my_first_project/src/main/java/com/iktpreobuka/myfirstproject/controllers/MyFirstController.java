package com.iktpreobuka.myfirstproject.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstController {

	private final int[] numArr = {19, 6, 8, 11, 25, 2};

	private static final Map<String, String> dictionary = Map.of(
			"gospodar", "lord",
			"prsten", "ring",
			"pivo", "beer"
			);


	@GetMapping("/")
	public String hello() {
		return "<html><h1>My First Spring App</h1></html>";
	}

	@GetMapping("/greetings")
	public String greet() {
		return "<html><h2>Hello Frodo!</h2></html>";
	}

	@GetMapping("/date")
	public String date() {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		Date date = new Date();

		return df.format(date);
	}

	@GetMapping("/family")
	public List<String> family() {
		List<String> fm = new ArrayList<>();

		fm.add("Frodo");
		fm.add("Samwise");
		fm.add("Peregrin");
		fm.add("Meriadoc");

		return fm;
	}

	@GetMapping("/myclass")
	public String showClass() {
		return   "<html>\n"
				+ "<head>\n"
				+ "<title>Fellowship</title>\n"
				+ "<style>"
				+ "body {margin: 0; color: hsl(0deg, 0%, 95%);}"
				+ "main {width: 100%; height: 100svh; background-color: hsl(0deg, 0%, 5%); display: grid; place-items: center; overflow: hidden}"
				+ "table,th,td {border: 1px solid hsla(0deg, 0%, 95%, 0.5); padding: .5rem}"
				+ "</style>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "<main>\n"
				+ "<table>"
			    + "<tr>"
			        + "<th>Name</th>"
			        + "<th>Last name</th>"
			    + "</tr>"
			    + "<tr>"
			        + "<td>Frodo</td>"
			        + "<td>Baggins</td>"
			    + "</tr>"
			    + "<tr>"
			        + "<td>Aragorn</td>"
			        + "<td>Strider</td>"
			    + "</tr>"
			    + "<tr>"
			        + "<td>Legolas</td>"
			        + "<td>Greenleaf</td>"
			    + "</tr>"
			    + "<tr>"
			        + "<td>Gimli</td>"
			        + "<td>Son of Glóin</td>"
			    + "</tr>"
			    + "<tr>"
			        + "<td>Gandalf</td>"
			        + "<td>Mithrandir</td>"
			    + "</tr>"
			    + "<tr>"
			        + "<td>Samwise</td>"
			        + "<td>Gamgee</td>"
			    + "</tr>"
			    + "<tr>"
			        + "<td>Meriadoc</td>"
			        + "<td>Brandybuck</td>"
			    + "</tr>"
			    + "<tr>"
			        + "<td>Peregrin</td>"
			        + "<td>Took</td>"
			    + "</tr>"
			    + "<tr>"
			        + "<td>Boromir</td>"
			        + "<td>Son of Denethor</td>"
			    + "</tr>"
			+ "</table>"
				+ "</body>\n"
				+ "</html>";
	}

	@GetMapping("/array")
	public int[] showArr() {
		return numArr;
	} 

	@GetMapping("/sortarray")
	public int[] sortArr() {

		int[] sortedNumArr = Arrays.copyOf(numArr, numArr.length);

		Arrays.sort(sortedNumArr);

		return sortedNumArr;
	} 

	@GetMapping("/minmax")
	public String minMax() {

		int min = Arrays.stream(numArr).min().orElseThrow();
		int max = Arrays.stream(numArr).max().orElseThrow();

		return "min: " + min + ", " + "max: " + max;
	}

	@GetMapping("/sumaniza/{n}")
	public int sumNums(@PathVariable int n) {
		int sum = 0;

		for (int i = 0; i <= n; i++) {
			sum += i;
		}

		return sum;
	}


	@GetMapping("/recnik/{word}")
	public String translate(@PathVariable String word) {
		String wordInEng = dictionary.get(word);

		if (wordInEng != null) {
			return wordInEng;
		} else {
			return "Reč '" + word + "' ne postoji u rečniku.";
		}
	}
}
