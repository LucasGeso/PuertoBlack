package unlam.edu.ar.pb2;

public class YateAMotor extends Yate {
	private Integer desplazamiento;
	private String propulsion;
	private Integer potencia;
	private Integer velocidad;
	private Integer autonomia;
	private final Integer costoPorAmarre = 10000;
	
	public YateAMotor(String nombre, String nombreDuenio, Double manga, Double calado, Double eslora, Integer tripulacion, Double peso, Integer desplazamiento, String propulsion, Integer potencia, Integer velocidad, Integer autonomia) {
		super(nombre, nombreDuenio, manga, calado, eslora, tripulacion, peso);
		this.desplazamiento = desplazamiento;
		this.propulsion = propulsion;
		this.potencia = potencia;
		this.velocidad = velocidad;
		this.autonomia = autonomia;
	}
	
	@Override
	public Integer costoDeAmarrePorMes() {
		Integer precio;
		
		precio = costoPorAmarre + super.importePorEslora();
		
		return precio;
	}

}
