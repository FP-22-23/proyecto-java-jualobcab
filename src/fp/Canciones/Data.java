package fp.Canciones;

import java.util.Objects;

import fp.utiles.Checkers;

public class Data {
	private String title;
	private String artist;
	private String country;

	public Data(String title, String artist, String country){
		this.title = title;
		this.artist = artist;
		this.country = country;
	}
	

	@Override
	public String toString() {
		return "Data [title=" + title + ", artist=" + artist + ", country=" + country + "]";
	}

	//Equals y Hash Code

	@Override
	public int hashCode() {
		return Objects.hash(artist, country, title);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		return Objects.equals(artist, other.artist) && Objects.equals(country, other.country)
				&& Objects.equals(title, other.title);
	}


	//Getters y Setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		Checkers.check("Error titulo de la canción", title != null);
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
