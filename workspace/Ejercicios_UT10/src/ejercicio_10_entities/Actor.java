package ejercicio_10_entities;

import java.util.Objects;

public class Actor implements Comparable<Actor>{
	
	//actor_id, first_name, last_name.
	private int actorId;
	private String firstName;
	private String lastName;
	public int getActorId() {
		return actorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	@Override
	public int hashCode() {
		return Objects.hash(actorId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		return actorId == other.actorId;
	}
	@Override
	public int compareTo(Actor o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.actorId, o.getActorId());
	}
	
	

}
