package TestCanciones;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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
	}
}
