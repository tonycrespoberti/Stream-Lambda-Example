import java.util.ArrayList;
import java.util.List;

public class Main {


	public static void main(String[] args) {

		List<Coche> listaCoches = new ArrayList<>();

		Coche coche1 = new Coche();
		Coche coche2 = new Coche();
		Coche coche3 = new Coche();

		coche1.setMarca("Ford");
		coche1.setModelo("Fiesta");
		coche1.setYear(2010);
		coche1.setNombre("Baldomero");
		coche1.setApellido("estéban");
	
		coche2.setMarca("Fiat");
		coche2.setModelo("500");
		coche2.setYear(2018);
		coche2.setNombre("Carlos");
		coche2.setApellido("Martinez");
		
		coche3.setMarca("Renault");
		coche3.setModelo("Clio");
		coche3.setYear(2020);
		coche3.setNombre("Cirilo");
		coche3.setApellido("Estéban");
		
		listaCoches.add(coche1);
		listaCoches.add(coche2);
		listaCoches.add(coche3);
		
		//Sin Lambdas ni Stream
		//Lo que haríamos normalmente
		System.out.println("\n[Modelo de todos los Coches]");
		for (Coche coche : listaCoches) {
			System.out.println("Modelo: " + coche.getModelo());
		}
		
		System.out.println("\n[Apellido de todos los propietario igual a Estéban]");
		for (Coche coche : listaCoches) {
			if (coche.getApellido().equalsIgnoreCase("estéban")) {
				System.out.println(coche.getNombre() + " " + coche.getApellido());
			}
		}
		
		System.out.println("\n[Año de todos los coches]");
		for (Coche coche : listaCoches) {
			System.out.println(coche.getYear());
		}
		
		System.out.println("\n[Promedio de año de los coches]");
		
		int sumaYear = 0;
		int totalCoches;

		Coche coche4;
		
		for (totalCoches = 0; totalCoches < listaCoches.size(); totalCoches++) {
			coche4 = listaCoches.get(totalCoches);
			sumaYear += coche4.getYear();
		}
		
		System.out.println("Promedio : " + sumaYear/totalCoches);
		
		
		//Usando Lambdas y Stream
		System.out.println("\nTodos los Coches usando Stream y Lanbda");
		listaCoches.stream()
		
			.forEach(lista -> System.out.println("Marca y Modelo: " + lista.getMarca() + " " + lista.getModelo()));
		

		System.out.println("\nTodos los Coches de los propietarios cuyos apellidos coincidan con estebán");
		listaCoches.stream()
		
			.filter(apellido -> apellido.getApellido().equalsIgnoreCase("estéban")) 
		
			.forEach(System.out::println);
		
		
		System.out.println("\nTodos los años de lo coches inferiores a 2017");
		listaCoches.stream()
			
			.filter(coche -> coche.getYear() < 2017)
			
			.map(coche -> coche.getYear()).forEach(System.out::println);
	}



	public static class Coche {

		private String marca;
		private String modelo;
		private int year;
		private String nombre;
		private String apellido;
		
		public Coche() {

		}

		public String getMarca() {
			return marca;
		}

		public String getModelo() {
			return modelo;
		}

		public int getYear() {
			return year;
		}

		public String getNombre() {
			return nombre;
		}
		
		public String getApellido() {
			return apellido;
		}
		
		public void setMarca(String marca) {
			this.marca = marca;
		}

		public void setModelo(String modelo) {
			this.modelo = modelo;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		@Override
		public String toString() {
			return "Coche [marca=" + marca + ", modelo=" + modelo + ", year=" + year + ", nombre=" + nombre
					+ ", apellido=" + apellido + "]";
		}
	}
}

