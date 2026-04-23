import java.time.LocalDateTime;

import entities.Ticket;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ticket t = new Ticket(1, LocalDateTime.now(), false);
		System.out.println(t.toString());

	}

}
