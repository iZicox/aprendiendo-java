package ejercicio_10_entities;

import java.util.Objects;

public class ActorFilm implements Comparable<ActorFilm>{
	//actor_id, film_id
	private int actorId;
	private int filmId;
	
	
	
	public ActorFilm(int actorId, int filmId) {
		super();
		this.actorId = actorId;
		this.filmId = filmId;
	}
	
	
	
	
	public int getActorId() {
		return actorId;
	}




	public int getFilmId() {
		return filmId;
	}




	@Override
	public int hashCode() {
		return Objects.hash(actorId, filmId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActorFilm other = (ActorFilm) obj;
		return actorId == other.actorId && filmId == other.filmId;
	}
	@Override
	public int compareTo(ActorFilm o) {
		// TODO Auto-generated method stub
		return this.compareTo(o);
	}
	@Override
	public String toString() {
		return "ActorFilm [actorId=" + actorId + ", filmId=" + filmId + "]";
	}
	
	
	
	
}
