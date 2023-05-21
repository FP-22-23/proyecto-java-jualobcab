package TestCanciones;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fp.Canciones.Cancion;
import fp.Canciones.Data;
import fp.Canciones.FactoriaCanciones;
import fp.Canciones.ListaCanciones;
import fp.Canciones.Popularity;


public class TestCanciones {

	public static void main(String[] args) {
		Cancion c1 = new Cancion(new Data("The Scientist", "Coldplay", "españa"), new ArrayList<String>(){{add("rap");add("pop");}},LocalDate.of(2002,11,30), LocalTime.of(12, 24), 146, 310, 5.00, false, 57494, Popularity.TOP_HITS) ;
		List<Cancion> canciones = FactoriaCanciones.leeCanciones("data/TopCanciones2000.csv");
		ListaCanciones lista = new ListaCanciones(canciones);

		for (Cancion x : canciones) {
			System.out.println(x);
		}
		
		System.out.println("------------------------------------------------------");
		
		testExisteCancion("Umbrella",lista);
		
		testMediaBPM(lista);
		
		testCancionesDeUnGenero("rock", lista);
		
		testCancionesPorAño(lista);
		
		testMapCancionesPorPaises(lista);
	}
	
	//Tests 
	public static void testExisteCancion(String nombreC, ListaCanciones listaCanciones) {
		Boolean res= listaCanciones.existeCancion(nombreC);
		System.out.println(res);
	}
	
	public static void testMediaBPM(ListaCanciones listaCanciones) {
		Double res= listaCanciones.mediaBPM();
		System.out.println(res);
	}
	
	public static void testCancionesDeUnGenero(String genero, ListaCanciones listaCanciones) {
		List<Cancion> res = listaCanciones.cancionesDeUnGenero(genero);
		System.out.println(res);
	}
	
	public static void testCancionesPorAño(ListaCanciones listaCanciones) {
		Map<Integer, List<Cancion>> res = listaCanciones.cancionesPorAño();
		System.out.println(res);
	}
	
	public static void testMapCancionesPorPaises(ListaCanciones listaCanciones) {
		Map<String, Integer> res = listaCanciones.mapCancionesPorPaises();
		System.out.println(res);
	}
}
