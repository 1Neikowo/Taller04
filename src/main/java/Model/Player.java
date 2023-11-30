package Model;

public class Player {

	private String position;
	private String nombre;
	private int numero;
	public Player(){
	}
	public Player(int numero, String nombre, String position) {
		this.nombre = nombre;
		this.position = position;
		this.numero = numero;
	}
	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String toString() {
		return "Nombre: " + this.nombre + ", Numero" + this.numero + ", Posicion: " + this.position;
	}

}