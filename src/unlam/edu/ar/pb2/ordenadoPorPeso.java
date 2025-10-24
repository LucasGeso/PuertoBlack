package unlam.edu.ar.pb2;

import java.util.Comparator;

public class ordenadoPorPeso implements Comparator<Yate>{

	@Override
	public int compare(Yate o1, Yate o2) {
		return o1.getPeso().compareTo(o2.getPeso());
	}
	

}
