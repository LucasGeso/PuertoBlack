package unlam.edu.ar.pb2;

public class YateAVela extends Yate{
	
	private Double alturaMastil;
	private Double superficieVelicaMayor;
	private Double superficieTotal;
	private final Integer costoPorAmarre = 9000;
	
	public YateAVela(String nombre, String nombreDuenio, Double manga, Double calado, Double eslora, Integer tripulacion, Double peso, Double alturaMastil, Double superficieVelica, Double superficieTotal) {
		super(nombre, nombreDuenio, manga, calado, eslora, tripulacion, peso);
		this.alturaMastil = alturaMastil;
		this.superficieVelicaMayor = superficieVelica;
		this.superficieTotal = superficieTotal;
	}
	
	@Override
	public Integer costoDeAmarrePorMes() {
		Integer precio;
		
		precio = costoPorAmarre + super.importePorEslora();
		
		return precio;
	}

}
