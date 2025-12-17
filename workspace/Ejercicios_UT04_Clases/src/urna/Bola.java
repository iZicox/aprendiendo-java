package urna;

public class Bola {

	private ColorBola color;

	public Bola(ColorBola color) {
		this.color = color;
	}

	public ColorBola getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "Bola [color=" + color + "]";
	}
	
	
	
}
