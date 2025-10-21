package unlam.edu.ar.pb2;

import java.util.LinkedHashSet;
import java.util.Set;

public class Fondeadero{
	
	private Set<Yate> yates;
	private Integer cantidadDeAmarres;
	
	public Fondeadero(Integer amarres) {
		this.yates = new LinkedHashSet<Yate>();
		this.cantidadDeAmarres = amarres;
	}
	
	public Integer getCantidadDeAmarres() {
		return cantidadDeAmarres;
	}
	
	public boolean amarrarYate(Yate yate) {
		if(this.yates.size()<this.cantidadDeAmarres && !this.yates.contains(yate)) {
			this.yates.add(yate);
			return true;
		}
		return false;
		
	}
	
	public boolean desamarrarYate(Yate yate) {
		return yates.remove(yate);
	}
	
	public Integer cantidadDeYatesAmarrados() {
		return this.yates.size();
	}
	
	public Integer cantidadDeAmarresDisponibles() {
		return this.cantidadDeAmarres - this.yates.size();
	}
	
	public Integer calcularImporteDeTodosLosAmarres() {
		Integer importeTotal = 0;
		
		for(Yate yate : yates) {
			importeTotal+= yate.costoDeAmarrePorMes();
		}
		/*Iterator<Yate> iterador;
		iterador = yates.iterator();
		
		if(iterador.hasNext()) {
			importeTotal += iterador.next().costoDeAmarrePorMes();
		}*/
		return importeTotal;
	}
}
