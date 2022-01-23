package eus.ehu.adsi.arkanoid;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import eus.ehu.adsi.arkanoid.core.Game;
import eus.ehu.adsi.arkanoid.view.Ball;
import eus.ehu.adsi.arkanoid.view.Brick;

public class Premios {

	@Test
	public void prueba0A() {
		System.out.println("Realizamos la primera prueba:");
		//Para realizar esta prueba y suponiendo que la identificación se realiza correctamente miramos el string que nos devuelve el metodo obtenerPremiosObtenidos
		String si = Arkanoid.obtenerPremiosObtenidos("urkazio");
		assertTrue(si.length()==0);
		String no = Arkanoid.obtenerPremiosNoObtenidos("urkazio");
		assertTrue(no.equals("Bronce8Diamante8Oro8Plata8Platino8Rubi8Zafiro8"));
	}
	
	@Test
	public void prueba0B() {
		String si = Arkanoid.obtenerPremiosObtenidos("urkazio");
		assertTrue(si.length()==0);
		String no = Arkanoid.obtenerPremiosNoObtenidos("urkazio");
		System.out.println(no);
		assertTrue(no.equals("Bronce8Diamante8Oro8Plata8Platino8Rubi8Zafiro8"));
		//Ahora cambiando el usuario debería cambiar el resultado (como si se hubiese logeado otra persona)
		String no1 = Arkanoid.obtenerPremiosNoObtenidos("endika1");
		assertTrue(no1.length()==0);
		String si1 = Arkanoid.obtenerPremiosObtenidos("endika1");
		assertTrue(si1.equals("Bronce8Diamante8Oro8Plata8Platino8Rubi8Zafiro8"));
	}
	
	@Test
	public void prueba1A() {
		//Para realizar esta prueba miramos los resultados que nos da el método obtenerPremiosObtenidos un usuario sin premios
		String si = Arkanoid.obtenerPremiosObtenidos("urkazio");
		assertTrue(si.length()==0);
		//Para realizar esta prueba miramos los resultados que nos da el método obtenerPremiosNoObtenidos un usuario sin premios
		String no = Arkanoid.obtenerPremiosNoObtenidos("urkazio");
		assertTrue(no.length()!=0);
	}
	
	@Test
	public void prueba1B() {
		//Para realizar esta prueba miramos los resultados que nos da el método  obtenerPremiosObtenidos un usuario con todos los premios
		String si = Arkanoid.obtenerPremiosObtenidos("endika1");
		assertTrue(si.length()!=0);
		//Para realizar esta prueba miramos los resultados que nos da el método obtenerPremiosNoObtenidos un usuario sin premios
		String no = Arkanoid.obtenerPremiosNoObtenidos("endika1");
		assertTrue(no.length()==0);
	}
	
	//Las pruebas que se proponen 2A y 2B no ocurren => No hago los casos de prueba.
	 
	@Test
	public void prueba3A() {
		//ESTA PRUEBA SOLO SIRVE UNA VEZ
		GestorBD.miGestorBD.execSQL2("INSERT INTO jugador VALUES('marcos','mm88','marcos@gmail.com','rojo','rojo','rojo','rojo')");
		GestorBD.miGestorBD.execSQL2("INSERT INTO partidanormal VALUES('1','marcos','2000-01-23 22:22:22','2000','1')");
		GestorBD.miGestorBD.execSQL2("INSERT INTO partidanormal VALUES('1','marcos','2000-01-23 22:22:23','2000','1')");
		GestorBD.miGestorBD.execSQL2("INSERT INTO partidanormal VALUES('1','marcos','2000-01-23 22:22:24','2000','1')");
		GestorBD.miGestorBD.execSQL2("INSERT INTO partidanormal VALUES('1','marcos','2000-01-23 22:22:25','2000','1')");
		GestorBD.miGestorBD.execSQL2("INSERT INTO partidanormal VALUES('1','marcos','2000-01-23 22:22:26','2000','1')");
		Arkanoid.entregarPremios("marcos");
		String si = Arkanoid.obtenerPremiosObtenidos("marcos");
		assertTrue(si.length()!=0);
	}
	
	@Test
	public void prueba3B() {
		//El anterior ejemplo ya cumple con esta condici�n ya que gana 5 partidas totales y 5 partidas seguidas
		GestorBD.miGestorBD.execSQL2("INSERT INTO jugador VALUES('marcos','mm88','marcos@gmail.com','rojo','rojo','rojo','rojo')");
		GestorBD.miGestorBD.execSQL2("INSERT INTO partidanormal VALUES('1','marcos','2000-01-23 22:22:22','2000','1')");
		GestorBD.miGestorBD.execSQL2("INSERT INTO partidanormal VALUES('1','marcos','2000-01-23 22:22:23','2000','1')");
		GestorBD.miGestorBD.execSQL2("INSERT INTO partidanormal VALUES('1','marcos','2000-01-23 22:22:24','2000','1')");
		GestorBD.miGestorBD.execSQL2("INSERT INTO partidanormal VALUES('1','marcos','2000-01-23 22:22:25','2000','1')");
		GestorBD.miGestorBD.execSQL2("INSERT INTO partidanormal VALUES('1','marcos','2000-01-23 22:22:26','2000','1')");
		Arkanoid.entregarPremios("marcos");
		String si = Arkanoid.obtenerPremiosObtenidos("marcos");
		assertTrue(si.length()!=0);
	}
	
	//La prueba que se propone en el 4A no sucede.
	
	@Test
	public void prueba4B() {
		//El entregar premios comprueba el n�mero de victorias y racha.
		//Posteriormente comprueba si hay premios ya obtenidos.
		//Finalmente inserta.
		//En caso de que este método no funcione debería salirnos un error en sql de fila duplicada cosa que no ocurre en esta jUnit.
		//El error que nos sale es de las anteriores al hacer los mismos inserts
		Arkanoid.entregarPremios("anegda");
	}
	
	public void prueba4D() {
		//El entregar premios comprueba el número de victorias y racha.
		//Posteriormente comprueba si hay premios ya obtenidos.
		//Finalmente inserta.
		//En caso de que este método no funcione debería salirnos un error en sql de fila duplicada cosa que no ocurre.
		//El error que nos sale es de las anteriores al hacer los mismos inserts
		Arkanoid.entregarPremios("endika1");
	}


	//La prueba que se propone en el 5A no sucede.	
	
	@Test
	public void prueba5B() {
		//El entregar premios comprueba el número de victorias y racha.
		//Posteriormente comprueba si hay premios ya obtenidos.
		//Finalmente inserta.
		//En caso de que este método no funcione debería salirnos un error en sql de fila duplicada cosa que no ocurre.
		Arkanoid.entregarPremios("anegda");
	}

	@Test
	public void prueba6A() {
		//Realizado en conjunto en la 5b
		//Ya se realiza con el usuario "anegda" y "endika1" ya que endika1 ya tiene todos los premios
		//anegda obtiene sus premios correctamente como hemos comprobado anteriormente
		Arkanoid.entregarPremios("anegda");
		Arkanoid.entregarPremios("endika1");
	}
	
	@Test
	public void prueba6B() {
		//Realizado en conjunto en la 5b
		//Ya se realiza con el usuario "anegda" y "endika1" ya que endika1 ya tiene todos los premios
		//anegda obtiene sus premios correctamente como hemos comprobado anteriormente
		Arkanoid.entregarPremios("anegda");
		Arkanoid.entregarPremios("endika1");
	}
	
	@Test
	public void prueba6C() {
		//Realizado en conjunto en la 5b
		//Ya se realiza con el usuario "anegda", "endika1" y "urkazio" ya que endika1 ya tiene todos los premios y urkazio ninguno.
		//anegda obtiene sus premios correctamente como hemos comprobado anteriormente
		Arkanoid.entregarPremios("anegda");
		Arkanoid.entregarPremios("endika1");
		Arkanoid.entregarPremios("urkazio");
	}
	
}
