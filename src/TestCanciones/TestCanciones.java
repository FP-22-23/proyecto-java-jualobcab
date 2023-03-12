package TestCanciones;

import java.time.LocalDate;
import java.util.ArrayList;

import fp.Canciones.Canciones;
import fp.Canciones.Data;
import fp.Canciones.Popularity;


public class TestCanciones {
	
	public static void main(String[] args) {
		Canciones c1 = new Canciones(new Data("The Scientist", "Coldplay", "españa"), new ArrayList<String>(){{add("rap");add("pop");}},
				LocalDate.of(2002,11,30), 146, 310, 5.00, false, 57494, Popularity.TOP_HITS) ; 
		Canciones c2 = new Canciones(new Data("The Scientist", "Coldplay", "españa"), LocalDate.of(2003,02,23), 310, 2.74,
				true, 743204);
		
		
		System.out.println("Informacion completa de la canción:" + c1);
		System.out.println("Primer constructor:" + c1);
		System.out.println("Segundo constructor:" + c2);
		System.out.println("El numero de beats totales es:" + c1.beatsTotales());
		
		System.out.println(c1.toString());
		System.out.println(c1.equals(c2));
		System.out.println(c1.compareTo(c2));
	}
}
