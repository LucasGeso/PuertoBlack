package unlam.edu.ar.pb2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestFondeadero {

	@Test
	void queElFondeaderoSecreeCorrectamenteConSuCantidadDeAmarres() {
		Fondeadero puerto = new Fondeadero(70);
		assertEquals(70, puerto.getCantidadDeAmarres());
	}
	
	
	@Test
	void queSePuedaAmarrarUnYate() {
		Fondeadero puerto = new Fondeadero(70);
		Yate yate1 = new YateAMotor("AZ1", "Andrés Borgeat", 18.87, 5.15, 119.9,  37, 5500.0, 5959, "2 x motores diésel MAN RK2805", 9000, 23, 6500);
		Yate yate2 = new YateAVela("XXR", "Sebastían Pardo", 6.90, 2.7, 13.45, 5, 1400.0, 21.5, 85.0, 133.0);
		assertTrue(puerto.amarrarYate(yate1));
		assertTrue(puerto.amarrarYate(yate2));
	}

	
	@Test
	void queSePuedaDesamarrarUnYate() {
		Fondeadero puerto = new Fondeadero(70);
		Yate yate1 = new YateAMotor("AZ1", "Andrés Borgeat", 18.87, 5.15, 119.9,  37, 5500.0, 5959, "2 x motores diésel MAN RK2805", 9000, 23, 6500);
		Yate yate2 = new YateAVela("XXR", "Sebastían Pardo", 6.90, 2.7, 13.45, 5, 1400.0, 21.5, 85.0, 133.0);
		puerto.amarrarYate(yate1);
		puerto.amarrarYate(yate2);
		assertTrue(puerto.desamarrarYate(yate1));
		assertTrue(puerto.desamarrarYate(yate2));
	}
	
	
	@Test
	void queNosMuestreLaCantidadDeYatesAmarrados() {
		Fondeadero puerto = new Fondeadero(70);
		Yate yate1 = new YateAMotor("AZ1", "Andrés Borgeat", 18.87, 5.15, 119.9,  37, 5500.0, 5959, "2 x motores diésel MAN RK2805", 9000, 23, 6500);
		Yate yate2 = new YateAVela("XXR", "Sebastían Pardo", 6.90, 2.7, 13.45, 5, 1400.0, 21.5, 85.0, 133.0);
		puerto.amarrarYate(yate1);
		puerto.amarrarYate(yate2);
		assertEquals(Integer.valueOf(2), puerto.cantidadDeYatesAmarrados());
	}
	
	
	@Test
	void queNosMuestreLaCantidadDeAmarresLibres() {
		Fondeadero puerto = new Fondeadero(70);
		Yate yate1 = new YateAMotor("AZ1", "Andrés Borgeat", 18.87, 5.15, 119.9,  37, 5500.0, 5959, "2 x motores diésel MAN RK2805", 9000, 23, 6500);
		Yate yate2 = new YateAVela("XXR", "Sebastían Pardo", 6.90, 2.7, 13.45, 5, 1400.0, 21.5, 85.0, 133.0);
		puerto.amarrarYate(yate1);
		puerto.amarrarYate(yate2);
		assertEquals(Integer.valueOf(68), puerto.cantidadDeAmarresDisponibles());
	}
	
	
	@Test
	void obtenerElPrecioPorAmarre() {
		Yate yate1 = new YateAMotor("AZ1", "Andrés Borgeat", 18.87, 5.15, 119.9,  37, 5500.0, 5959, "2 x motores diésel MAN RK2805", 9000, 23, 6500);
		Yate yate2 = new YateAVela("XXR", "Sebastían Pardo", 6.90, 2.7, 13.45, 5, 1400.0, 21.5, 85.0, 133.0);
		assertEquals(Integer.valueOf(13000),yate1.costoDeAmarrePorMes());
		assertEquals(Integer.valueOf(11000),yate2.costoDeAmarrePorMes());
	}
	
	
	@Test
	void obtenerRecaudacionTotalDeLosAmarres() {
		Fondeadero puerto = new Fondeadero(70);
		Yate yate1 = new YateAMotor("AZ1", "Andrés Borgeat", 18.87, 5.15, 119.9,  37, 5500.0, 5959, "2 x motores diésel MAN RK2805", 9000, 23, 6500);
		Yate yate2 = new YateAVela("XXR", "Sebastían Pardo", 6.90, 2.7, 13.45, 5, 1400.0, 21.5, 85.0, 133.0);
		puerto.amarrarYate(yate1);
		puerto.amarrarYate(yate2);
		assertEquals(Integer.valueOf(24000), puerto.calcularImporteDeTodosLosAmarres());
		
	}
	
}
