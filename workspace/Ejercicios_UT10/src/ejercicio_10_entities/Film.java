package ejercicio_10_entities;

import java.util.Objects;

public class Film implements Comparable<Film> {
	//film_id, title, description, release_year, length, rating
	private int filmId;
	private String title;
	private String description;
	private int releaseYear;
	private int lenght;
	private String rating;
	
	
	
	public Film(int filmId, String title, String description, int releaseYear, int lenght, String rating) {
		super();
		this.filmId = filmId;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.lenght = lenght;
		this.rating = rating;
	}
	public int getFilmId() {
		return filmId;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public int getLenght() {
		return lenght;
	}
	public String getRating() {
		return rating;
	}
	@Override
	public int hashCode() {
		return Objects.hash(filmId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return filmId == other.filmId;
	}
	@Override
	public int compareTo(Film o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.filmId, o.getFilmId());
	}
	
	
}
