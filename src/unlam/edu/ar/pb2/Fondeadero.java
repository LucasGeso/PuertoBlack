package unlam.edu.ar.pb2;

import java.util.ArrayList;

public class Fondeadero extends Object {
	
	private ArrayList<Yate> yates;
	private Integer cantidadDeAmarres;
	
	public Fondeadero(Integer amarres) {
		super();
		this.yates = new ArrayList<Yate>();
		this.cantidadDeAmarres = amarres;
	}
	
	public Integer getCantidadDeAmarres() {
		return cantidadDeAmarres;
	}
	
	public boolean amarrarYate(Yate yate) {
		if(this.yates.size()<this.cantidadDeAmarres) {
			this.yates.add(yate);
			return true;
		}
		return false;
	}
	
	public boolean desamarrarYate(Yate yate) {
		if(yates.contains(yate)) {
			yates.remove(yate);
			return true;
		}
		
		return false;
	}
	
	
	public Integer cantidadDeYatesAmarrados() {
		return this.yates.size();
	}
	
	
	public Integer cantidadDeAmarresDisponibles() {
		return this.cantidadDeAmarres - this.yates.size();
	}
	
	
	public Integer calcularImporteDeTodosLosAmarres() {
		Integer importeTotal = 0;
		
		for(int i=0; i<this.yates.size(); i++) {
			importeTotal += yates.get(i).costoDeAmarrePorMes();
		}
		
		return importeTotal;
	}
	

}
