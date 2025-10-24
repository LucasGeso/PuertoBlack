package unlam.edu.ar.pb2;

import java.util.Objects;

abstract class Yate implements Comparable<Yate> {
	
	private String nombre;
	private String nombreDuenio;
	private Double manga;
	private Double calado;
	private Double eslora;
	private Integer tripulacion;
	private Double peso;
	
	public Yate (String nombre, String nombreDuenio, Double manga, Double calado, Double eslora, Integer tripulacion, Double peso) {
		this.nombre = nombre;
		this.nombreDuenio = nombreDuenio;
		this.manga = manga;
		this.calado = calado;
		this.eslora = eslora;
		this.tripulacion = tripulacion;
		this.peso = peso;
	}
	
	public Integer importePorEslora() {
		Integer precio;
		
		if(this.eslora<=20.0) {
			precio = 2000;
		} else {
			precio = 3000;
		}
		return precio;
	}
	
	public abstract Integer costoDeAmarrePorMes();
	
	

	public Double getPeso() {
		return peso;
	}
	
	public Double getEslora() {
		return eslora;
	}

	@Override
	public int hashCode() {
		return Objects.hash(eslora, nombre, peso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Yate other = (Yate) obj;
		return Objects.equals(eslora, other.eslora) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(peso, other.peso);
	}

	@Override
	public int compareTo(Yate nuevo) {
		return this.getEslora().compareTo(nuevo.getEslora());
	}

	@Override
	public String toString() {
		return "Yate [nombre=" + nombre + ", eslora=" + eslora + ", peso=" + peso + "]";
	}
	
	
	
}
