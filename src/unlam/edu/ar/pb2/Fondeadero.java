package unlam.edu.ar.pb2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class Fondeadero{
	
	private Set<Yate> yates;
	private Integer cantidadDeAmarres;
	
	public Fondeadero(Integer amarres) {
		this.yates = new TreeSet<Yate>();
		this.cantidadDeAmarres = amarres;
	}
	
	public Integer getCantidadDeAmarres() {
		return cantidadDeAmarres;
	}
	
	public boolean amarrarYate(Yate yate) {
		if(yates.size()<cantidadDeAmarres && !yates.contains(yate)) {
			yates.add(yate);
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

	public Set<Yate> getYates() {
		return yates;
	}
	
	public List<Yate> ordenarYatesPorPeso(){
		List<Yate> ordenado = new ArrayList<Yate>(this.yates);
		Collections.sort(ordenado, new ordenadoPorPeso());
		return ordenado;
	}
	

}
