package fp.utiles;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import fp.Canciones.Popularity;


public class Parsers {

	public static List<String> parseaGeneros(String genre1, String genre2, String genre3){
		List<String> res = new ArrayList<String>();
		if (!genre1.isEmpty()) {
			res.add(genre1);
		}
		if (!genre2.isEmpty()) {
			res.add(genre2);
		}
		if (!genre3.isEmpty()) {
			res.add(genre3);
		}
		return res;
	}
	
	public static Boolean parseaBoolean(String award) {
		Boolean res = null;
		if (award.equals("0")) {
			res = false;
		}
		else if (award.equals("1")){
			res = true;
		}
		return res;
	}
	
	public static Popularity parseaPopularity(String pop) {
		Integer indice = Integer.parseInt(pop);
		Popularity res = null;
		
		if (indice>=81) {
			res = Popularity.TOP_HITS;
		}
		else if (indice<81 && indice>=75) {
			res = Popularity.MUY_POPULAR; 
		}
		else if (indice<75 && indice>=60) {
			res = Popularity.POPULAR; 
		}
		else if (indice<60){
			res = Popularity.POCO_POPULAR;
		}
		
		return res;
	}
	
	public static LocalTime parseaHora(String hora) {
		LocalTime res = null;
		
		if (hora.length()<5) {
			hora = "0" + hora;
		}
		return LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));
	}
	
}
