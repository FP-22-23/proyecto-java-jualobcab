package TestCanciones;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import fp.Canciones.Cancion;
import fp.Canciones.Data;
import fp.Canciones.Popularity;


public class TestCancion {
	
	public static void main(String[] args) {
		Cancion c1 = new Cancion(new Data("The Scientist", "Coldplay", "españa"), new ArrayList<String>(){{add("rap");add("pop");}},
				LocalDate.of(2002,11,30), LocalTime.of(12, 24), 146, 310, 5.00, false, 57494, Popularity.TOP_HITS) ; 
		Cancion c2 = new Cancion(new Data("The Scientist", "Coldplay", "españa"), LocalDate.of(2003,02,23), LocalTime.of(12, 24), 310, 2.74,
				true, 743204);
		
		
		System.out.println("Informacion completa de la canción:" + c1);
		System.out.println("Primer constructor:" + c1);
		System.out.println("Segundo constructor:" + c2);
		System.out.println("El numero de beats totales es: " + c1.beatsTotales());
		
		System.out.println(c1.toString());
		System.out.println(c1.equals(c2));
		System.out.println(c1.compareTo(c2));
	}
}
