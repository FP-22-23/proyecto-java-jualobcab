package fp.Canciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.utiles.Checkers;
import fp.Canciones.Popularity;


public class ListaCanciones {
	private List<Cancion> Canciones;
	
	//Constructor 1
	public ListaCanciones() {
		this.Canciones = new ArrayList<Cancion>();
	} 
	
	//Constructor 2
	public ListaCanciones(List<Cancion> listaCanciones) {
        this.Canciones = new ArrayList<>(listaCanciones);
	}
	
	//Constructor 3
	public ListaCanciones(Stream<Cancion> listaCanciones) {
        this.Canciones = listaCanciones.collect(Collectors.toList());
	}
	
	//Getter
	public List<Cancion> getCanciones(){
		return Canciones;

	}

	//HashCode
	@Override
	public int hashCode() {
		return Objects.hash(Canciones);
	}

	//Equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaCanciones other = (ListaCanciones) obj;
		return Objects.equals(Canciones, other.Canciones);
	}

	//To String
	@Override
	public String toString() {
		return "ListaCanciones [Canciones=" + Canciones + "]";
	}

	//Operaciones
	public Integer getNumeroCanciones() {
		return Canciones.size();
	}

	public void agregarCanciones(Cancion c) {
		Canciones.add(c);
	}

	public void agregaCanciones(Collection<Cancion> canciones) {
		this.Canciones.addAll(canciones);
	}

	public void eliminaCancion(Cancion c) {
		Checkers.check("La cancion no está en la lista", Canciones.contains(c));
		Canciones.remove(c);
	}

	//Tipo 1
	public Boolean existeCancion(String title) {
		Boolean res = false;
		for (Cancion c : Canciones) {
			if (title.equals(c.getData().getTitle())) {
				res = true;
				break;
			}
		}
		return res;
		
	}
	
	//Tipo 2
	public Double mediaBPM() {
		Double res = null;
		Double total = 0.0;
		
		for (Cancion c : Canciones) {
			total += c.getBpm();
		}
		
		res = total/Canciones.size();
		return res;
	}
	

	//Tipo 3
	public List<Cancion> cancionesDeUnGenero(String genero){
		List<Cancion> res = new ArrayList<Cancion>();
		
		for (Cancion c : Canciones) {
			if (c.getGenres().contains(genero)) {
				res.add(c);
			}
		}
		return res;	
	}
	
	//Tipo 4
	public Map<Integer, List<Cancion>> cancionesPorAño() {
		Map<Integer, List<Cancion>> res = new HashMap<Integer, List<Cancion>>();
		for (Cancion c : Canciones) {
			Integer clave = c.getDate().getYear();
			if (res.containsKey(clave)) {
				res.get(clave).add(c);
			} else {
				List<Cancion> lista = new ArrayList<Cancion>();
				lista.add(c);
				res.put(clave, lista);
			}
		}
		return res;
	}
	
	//Tipo 5
	public Map<String, Integer> mapCancionesPorPaises(){
    	Map<String,Integer> res = new HashMap<String, Integer>();
    	for (Cancion p: Canciones) {
    		String clave = p.getData().getCountry();
    		if (res.containsKey(clave)) {
    			Integer valor = res.get(clave);
    			valor++;
    			res.put(clave, valor);
    		} else {
    			res.put(clave, 1);
    		}
    	}
    	return res;
    }
	
	//---------------  ENTREGA 3  ---------------
	
	// BLOQUE I
	// Tipo 1
	public Boolean existeCancion2(String title) {
		return this.Canciones.stream().anyMatch(c->c.getData().getTitle().equals(title));
	}
	
	// Tipo 2
	public Double mediaBPM2() {
		return this.Canciones.stream().mapToInt(Cancion::getBpm).average().getAsDouble();
	}
	
	// Tipo 3
	public List<Cancion> cancionesDeUnGenero2(String genero){
		return this.Canciones.stream().filter(c -> c.getGenres().contains(genero)).collect(Collectors.toList());
	}
	
	// Tipo 4
	public Cancion cancionPremiadaMasReproducciones(Boolean award) {
		return this.Canciones.stream().filter(c -> c.getAward().equals(award)).max(Comparator.comparing(Cancion::getReproductions)).get();
	}
	
	// Tipo 5
	public List<Cancion> cancionesTopHitsOrdenadas(Popularity pop){
		return this.Canciones.stream().filter(c -> c.getPopularity().equals(pop)).sorted(Comparator.comparing(Cancion::getScore))
				.collect(Collectors.toList());
	}
	
	// BLOQUE II
	// Tipo 6
	public Map<Integer, List<Cancion>> mapCancionesPorAño2() {
		return this.Canciones.stream().collect(Collectors.groupingBy(c -> c.getDate().getYear(),
				Collectors.mapping(c -> c,Collectors.toList())));
	}
	
	// Tipo 7
	public Map<String, List<String>> mapArtistasPorPais(){
		return this.Canciones.stream().collect(Collectors.groupingBy(c -> c.getData().getCountry(),
				Collectors.mapping(c -> c.getData().getArtist(), Collectors.toList())));
	}
	
	// Tipo 8
	public Map<String, Cancion> mapCancionMaxValoracionPorPais(){
		return this.Canciones.stream().collect(Collectors.groupingBy(c -> c.getData().getCountry(),
				Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Cancion::getScore)), c2 -> c2.get())));
	}
	
	// Tipo 9
	public Map<String, List<String>> mejoresCancionesPorAutor(){
		return this.Canciones.stream().collect(Collectors.groupingBy(c -> c.getData().getArtist(), TreeMap::new, 
				Collectors.collectingAndThen(Collectors.toList(), list -> getCancionArtista(list))));
	}
	
	public List<String> getCancionArtista(List<Cancion> lista){
		return lista.stream().sorted(Comparator.comparing(Cancion::getScore)).limit(2).map(c -> c.getData().getTitle())
				.collect(Collectors.toList());
	}
	
	// Tipo 10
	public String getArtistaMejorValorado() {
		Map<String, Double> map = this.Canciones.stream().collect(Collectors.groupingBy(c -> c.getData().getArtist(),
				Collectors.averagingDouble(Cancion::getScore)));
		return map.entrySet().stream().max(Comparator.comparing(Entry::getValue)).get().getKey();
	}
	
	
	
	
	
	
	
}
