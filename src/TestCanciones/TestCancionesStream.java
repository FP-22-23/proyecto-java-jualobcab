package TestCanciones;

import java.util.List;
import java.util.Map;

import fp.Canciones.Cancion;
import fp.Canciones.FactoriaCanciones;
import fp.Canciones.ListaCanciones;
import fp.Canciones.Popularity;

public class TestCancionesStream {
	public static void main(String[] args) {
		List<Cancion> canciones = FactoriaCanciones.leeCanciones("data/TopCanciones2000.csv");
		ListaCanciones lista = new ListaCanciones(canciones);
		
		//-------------------  LLAMADA A LOS METODOS  ------------------------
		// TIPO 1
        System.out.println("----------------------------------- TIPO 1 -----------------------------------");
        testExisteCancion2("The Scientist", lista);
        
        // TIPO 2
        System.out.println("----------------------------------- TIPO 2 -----------------------------------");
        testMediaBPM2(lista);
        
        // TIPO 3
        System.out.println("----------------------------------- TIPO 3 -----------------------------------");
        testCancionesDeUnGenero2("rock", lista);
        
        // TIPO 4
        System.out.println("----------------------------------- TIPO 4 -----------------------------------");
        testCancionPremiadaMasReproducciones(true, lista);
        
        // TIPO 5
        System.out.println("----------------------------------- TIPO 5 -----------------------------------"); 
        testCancionesTopHitsOrdenadas(Popularity.TOP_HITS, lista);
        
        // TIPO 6
        System.out.println("----------------------------------- TIPO 6 -----------------------------------"); 
        testMapCancionesPorAño2(lista);
        
        // TIPO 7
        System.out.println("----------------------------------- TIPO 7 -----------------------------------");
        testMapArtistasPorPais(lista);
        
        // TIPO 8
        System.out.println("----------------------------------- TIPO 8 -----------------------------------");
        testMapCancionMaxValoracionPorPais(lista);
        
        // TIPO 9
        System.out.println("----------------------------------- TIPO 9 -----------------------------------");
        testMejoresCancionesPorAutor(lista);
        
        // TIPO 10
        System.out.println("----------------------------------- TIPO 10 -----------------------------------");
        testGetArtistaMejorValorado(lista);
		
	}
	
	//-----------------------  TESTS BLOQUE I  ---------------------------
	// TIPO 1
	public static void testExisteCancion2(String title, ListaCanciones listaCanciones) {
		Boolean res= listaCanciones.existeCancion2(title);
		System.out.println(res);
	}
	
	// TIPO 2
	public static void testMediaBPM2(ListaCanciones listaCanciones) {
		Double res= listaCanciones.mediaBPM2();
		System.out.println(res);
	}
	
	// TIPO 3
	public static void testCancionesDeUnGenero2(String genero, ListaCanciones listaCanciones) {
		List<Cancion> res = listaCanciones.cancionesDeUnGenero2(genero);
		System.out.println(res);
	}

	// TIPO 4
	public static void testCancionPremiadaMasReproducciones(Boolean award, ListaCanciones listaCanciones) {
		Cancion res = listaCanciones.cancionPremiadaMasReproducciones(award);
		System.out.println(res);
	}

	// TIPO 5
	public static void testCancionesTopHitsOrdenadas(Popularity pop, ListaCanciones listaCanciones) {
		List<Cancion> res = listaCanciones.cancionesTopHitsOrdenadas(pop);
		System.out.println(res);
	}

	//-----------------------  TESTS BLOQUE II  ---------------------------
	// TIPO 6
	public static void testMapCancionesPorAño2(ListaCanciones listaCanciones) {
		Map<Integer, List<Cancion>> res = listaCanciones.mapCancionesPorAño2();
		System.out.println(res);
	}

	// TIPO 7
	public static void testMapArtistasPorPais(ListaCanciones listaCanciones) {
		Map<String, List<String>> res = listaCanciones.mapArtistasPorPais();
		System.out.println(res);
	}

	// TIPO 8
	public static void testMapCancionMaxValoracionPorPais(ListaCanciones listaCanciones) {
		Map<String, Cancion> res = listaCanciones.mapCancionMaxValoracionPorPais();
		System.out.println(res);
	}

	// TIPO 9
	public static void testMejoresCancionesPorAutor(ListaCanciones listaCanciones) {
		Map<String, List<String>> res = listaCanciones.mejoresCancionesPorAutor();
		System.out.println(res);
	}

	// TIPO 10
	public static void testGetArtistaMejorValorado(ListaCanciones listaCanciones) {
		String res = listaCanciones.getArtistaMejorValorado();
		System.out.println(res);
	}

}
