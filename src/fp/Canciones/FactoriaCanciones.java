package fp.Canciones;

import fp.utiles.Checkers;
import fp.utiles.Ficheros;
import fp.utiles.Parsers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import fp.Canciones.Data;
import fp.Canciones.Cancion;

public class FactoriaCanciones {
	public static Cancion parseaCanciones(String lineaCSV) {
		Checkers.checkNoNull(lineaCSV);
		String [] trozos =lineaCSV.split(";");

		Checkers.check("La longitud del array debe ser 14", trozos.length==14);

		//Parsear Data
		String title = trozos[0].trim();
		String artist = trozos[1].trim();
		String country = trozos[2].trim();
		Data data = new Data(title, artist, country);

		//Parsear genero
		List<String> genres = Parsers.parseaGeneros(trozos[3].trim(),trozos[4].trim(),trozos[5].trim());

		//Parsea fecha y hora
		LocalDate fecha = LocalDate.parse(trozos[6].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalTime time = Parsers.parseaHora(trozos[7].trim());

		//Parsea Integer y Double
		Integer bpm = Integer.parseInt(trozos[8].trim());
		Integer duration = Integer.parseInt(trozos[9].trim());
		Double score = Double.parseDouble((trozos[10].trim()).replace(",", "."));
		Integer reproductions = Integer.parseInt(trozos[12].trim());

		//Parsea Boolean
		Boolean award = Parsers.parseaBoolean(trozos[11].trim());

		//Parsea Enum
		Popularity pop = Parsers.parseaPopularity(trozos[13].trim());

		return new Cancion(data, genres, fecha, time, bpm, duration, score, award, reproductions, pop);
	}

	public static List<Cancion> leeCanciones(String rutaFichero) {
		Checkers.checkNoNull(rutaFichero);
		List<String> lineas =
				//Aquí esta leyendo los datos y metiendolos en un lista transformandolos en cadena
				Ficheros.leeFichero("Error leyendo fichero", rutaFichero);

		//Para quitar la primera linea del fichero que es donde suelen venir los nombres de las columnas
		lineas.remove(0);

		List<Cancion> res =new ArrayList<Cancion>();
		for(String linea:lineas) {
			Cancion c = parseaCanciones(linea);
			res.add(c);
		}
		return res;
	}
	
	public static ListaCanciones leefichero2(String rutaFichero){
        Checkers.checkNoNull(rutaFichero);
        Stream<Cancion> res;
        ListaCanciones c = null;
        try {
            res = Files.lines(Paths.get(rutaFichero)).skip(1).map(FactoriaCanciones::parseaCanciones);
            c = new ListaCanciones(res);
        } catch (IOException e) {
            System.out.println("No se ha encontrado el fichero " + rutaFichero);
            e.printStackTrace();
        }
        return c;
    } 
}
