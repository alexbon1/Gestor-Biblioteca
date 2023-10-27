package packUnico;

public class Principal {
	static BusquedaLibros gestorBiblioteca = new BusquedaLibros();
	static Prestamos prestamo = new Prestamos();

	public static void main(String[] args) {

		gestorBiblioteca.setVisible(true);

	}

	public static void cambiarAPrestamo() {
		gestorBiblioteca.dispose();

		prestamo.setVisible(true);
	}

	public static void cambiarABusqueda() {
		prestamo.dispose();

		gestorBiblioteca.setVisible(true);
	}
}
