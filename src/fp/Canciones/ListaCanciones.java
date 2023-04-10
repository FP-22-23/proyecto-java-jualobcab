package fp.Canciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import fp.utiles.Checkers;


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
	
}
