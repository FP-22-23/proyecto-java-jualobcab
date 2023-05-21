package fp.Canciones;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import fp.utiles.Checkers;


public class Cancion {
	private Data data;
	private List<String> genres;
	private LocalDate date;
	private LocalTime time;
	private Integer bpm;
	private Integer duration;
	private Double score;
	private Boolean award;
	private Integer reproductions;
	private Popularity popularity;
	
	
	//Constructor 1
	public Cancion(Data data, List<String> genres, LocalDate date, LocalTime time, Integer bpm, Integer duration, Double score,
			Boolean award, Integer reproductions, Popularity popularity) {
		this.data = data;
		this.genres = genres;
		this.date = date;
		this.time = time;
		this.bpm = bpm;
		this.duration = duration;
		this.score = score;
		this.award = award;
		this.reproductions = reproductions;
		this.popularity = popularity;
	}


	//Constructor 2
	public Cancion(Data data, LocalDate date, LocalTime time, Integer duration, Double score, Boolean award, Integer reproductions) {
		this.data = data;
		this.date = date;
		this.time = time;
		this.duration = duration;
		this.score = score;
		this.award = award;
		this.reproductions = reproductions;
	}
	
	public Integer beatsTotales() {
		return ((this.bpm*this.duration)/60);
	}

	
	//compareTo
		public int compareTo(Cancion j) {
			int c;
			if (j == null) {
				throw new NullPointerException();
			}

			c = date.compareTo(j.date);
			if (c == 0) {
				c = duration.compareTo(j.duration);
				if (c==0) {
					c = score.compareTo(j.score);
				}
			}
			return c;

		}
		

	//Hash code y equals
	@Override
	public int hashCode() {
		return Objects.hash(data, duration);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cancion other = (Cancion) obj;
		return Objects.equals(data, other.data) && Objects.equals(duration, other.duration);
	}


	//Representacion como cadena
	@Override
	public String toString() {
		return "Cancion [data=" + data + ", genres=" + genres + ", date=" + date + ", time=" + time + ", bpm=" + bpm + ", duration="
				+ duration + ", score=" + score + ", award=" + award + ", reproductions=" + reproductions
				+ ", popularity=" + popularity + "]";
	}


	public Data getData() {
		return data;
	}


	public void setData(Data data) {
		this.data = data;
	}


	public List<String> getGenres() {
		return genres;
	}


	public void setGenres(List<String> genres) {
		this.genres = genres;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		Checkers.check("El año de salida de la cancion debe ser ", (date.isAfter(LocalDate.of(1998,12,31)))&&(date.isBefore(LocalDate.of(2011,1,1))));
		this.date = date;
	}
	

	public LocalTime getTime() {
		return time;
	}


	public void setTime(LocalTime time) {
		this.time = time;
	}
	

	public Integer getBpm() {
		return bpm;
	}


	public void setBpm(Integer bpm) {
		this.bpm = bpm;
	}


	public Integer getDuration() {
		return duration;
	}


	public void setDuration(Integer duration) {
		Checkers.check("La duracion debe ser positiva", duration > 0);
		this.duration = duration;
	}


	public Double getScore() {
		return score;
	}


	public void setScore(Double score) {
		this.score = score;
	}


	public Boolean getAward() {
		return award;
	}


	public void setAward(Boolean award) {
		this.award = award;
	}


	public Integer getReproductions() {
		return reproductions;
	}


	public void setReproductions(Integer reproductions) {
		Checkers.check("Las reproducciones no pueden ser negativas", reproductions >= 0);
		this.reproductions = reproductions;
	}


	public Popularity getPopularity() {
		return popularity;
	}


	public void setPopularity(Popularity popularity) {
		this.popularity = popularity;
	}
	
	
}
