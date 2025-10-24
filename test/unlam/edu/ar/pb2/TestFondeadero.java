package unlam.edu.ar.pb2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestFondeadero {
	
	Fondeadero puerto;
	//YATE 1 Y 3 A MOTOR -- YATE 2 Y 4 A VELA
	Yate yate1;
	Yate yate2;
	Yate yate3;
	Yate yate4;
	
	@BeforeEach
	void setUp() {
		puerto = new Fondeadero(70);
		yate1 = new YateAMotor("AZ1", "Andrés Borgeat", 18.87, 5.15, 119.9,  37, 5500.0, 5959, "2 x motores diésel MAN RK2805", 9000, 23, 6500);
		yate2 = new YateAVela("XXR", "Sebastían Pardo", 6.90, 2.7, 13.45, 5, 1400.0, 21.5, 85.0, 133.0);
		yate3 = new YateAMotor("AZ2", "Lucas Geso", 20.87, 6.15, 200.9,  40, 7500.0, 6000, "3 x motores diésel MAN RK2805", 9050, 25, 7500);
		yate4 = new YateAVela("XXW", "Johanna Guardia", 7.90, 3.7, 14.35, 6, 2400.0, 24.5, 87.0, 134.0);
	}

	@Test
	void queElFondeaderoSeCreeCorrectamenteConSuCantidadDeAmarres() {
		Fondeadero puerto = new Fondeadero(70);
		assertEquals(70, puerto.getCantidadDeAmarres());
	}
	
	@Test
	void queSePuedaAmarrarUnYate() {
		assertTrue(puerto.amarrarYate(yate1));
		assertTrue(puerto.amarrarYate(yate2));
		assertTrue(puerto.amarrarYate(yate3));
		assertTrue(puerto.amarrarYate(yate4));
	}
	
	@Test
	void queNoSePuedaAmarrarElMismoYateDosVeces() {
		assertTrue(puerto.amarrarYate(yate1));
		assertFalse(puerto.amarrarYate(yate1));
	}

	@Test
	void queSePuedaDesamarrarUnYate() {
		puerto.amarrarYate(yate1);
		puerto.amarrarYate(yate2);
		assertTrue(puerto.desamarrarYate(yate1));
		assertTrue(puerto.desamarrarYate(yate2));
	}
	
	@Test
	void queNosMuestreLaCantidadDeYatesAmarrados() {
		puerto.amarrarYate(yate1);
		puerto.amarrarYate(yate2);
		assertEquals(Integer.valueOf(2), puerto.cantidadDeYatesAmarrados());
	}	
	
	@Test
	void queNosMuestreLaCantidadDeAmarresLibres() {
		puerto.amarrarYate(yate1);
		puerto.amarrarYate(yate2);
		assertEquals(Integer.valueOf(68), puerto.cantidadDeAmarresDisponibles());
	}
	
	@Test
	void obtenerElPrecioPorAmarre() {
		assertEquals(Integer.valueOf(13000),yate1.costoDeAmarrePorMes());
		assertEquals(Integer.valueOf(11000),yate2.costoDeAmarrePorMes());
	}
		
	@Test
	void obtenerRecaudacionTotalDeLosAmarres() {
		puerto.amarrarYate(yate1);
		puerto.amarrarYate(yate2);
		assertEquals(Integer.valueOf(24000), puerto.calcularImporteDeTodosLosAmarres());	
	}
	
	@Test
	void queElFondaderoEsteOrdenadoPorLaEslora() {
		puerto.amarrarYate(yate1);
		puerto.amarrarYate(yate2);
		
		Set<Yate> pruebaOrden = new LinkedHashSet<Yate>();
		pruebaOrden.add(yate2); //2.7
		pruebaOrden.add(yate1); //5.15
		
		assertEquals(puerto.getYates(),pruebaOrden);
	}
	
	@Test
	void queSePuedaOrdenarPorElPesoDelYate() {
		puerto.amarrarYate(yate1);
		puerto.amarrarYate(yate2);
		puerto.amarrarYate(yate3);
		puerto.amarrarYate(yate4);
		
		List<Yate> pruebaOrden = new ArrayList<Yate>();
		pruebaOrden.add(yate2); //1400
		pruebaOrden.add(yate4); //2400
		pruebaOrden.add(yate1); //5500
		pruebaOrden.add(yate3); //7500
		
		assertEquals(puerto.ordenarYatesPorPeso(), pruebaOrden);
		
	}
	
}
