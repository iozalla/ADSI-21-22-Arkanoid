package eus.ehu.adsi.arkanoid;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import eus.ehu.adsi.arkanoid.view.Config;

public class AjustesTest {	
	
	@Test
	public void test0ABCD() {
		//cambiamos todos los colores a negro
		//comprobamos que han cambiado tanto en la BD como en la clase config
		Arkanoid.cambiarColores("anegda", "negro", "negro", "negro", "negro");
		assertTrue(Config.BACKGROUND_COLOR.equals(Color.black));
		assertTrue(Config.BALL_COLOR.equals(Color.black));
		assertTrue(Config.BRICK_COLOR.equals(Color.black));
		assertTrue(Config.PADDLE_COLOR.equals(Color.black));
		//cambiamos todos los colores a rojo
		//comprobamos que han cambiado tanto en la BD como en la clase config
		Arkanoid.cambiarColores("anegda", "rojo", "rojo", "rojo", "rojo");
		assertTrue(Config.BACKGROUND_COLOR.equals(Color.red));
		assertTrue(Config.BALL_COLOR.equals(Color.red));
		assertTrue(Config.BRICK_COLOR.equals(Color.red));
		assertTrue(Config.PADDLE_COLOR.equals(Color.red));
		String datos = Arkanoid.obtenerAjustes("anegda");
		assertTrue(datos.equalsIgnoreCase("rojo rojo rojo rojo"));
	}
	
	@Test
	public void test1A() {
		//cambiamos los colores a los que estaban seleccionados anteriormente
		//comprobamos si han cambiado tanto en la BD como en la clase config
		Arkanoid.cambiarColores("anegda", "rojo", "rojo", "rojo", "rojo");
		assertTrue(Config.BACKGROUND_COLOR.equals(Color.red));
		assertTrue(Config.BALL_COLOR.equals(Color.red));
		assertTrue(Config.BRICK_COLOR.equals(Color.red));
		assertTrue(Config.PADDLE_COLOR.equals(Color.red));
		String datos = Arkanoid.obtenerAjustes("anegda");
		assertTrue(datos.equalsIgnoreCase("rojo rojo rojo rojo"));
	}
	
	@Test
	public void test1B() {
		//cambiamos unicamente un color
		//comprobamos si han cambiado tanto en la BD como en la clase config
		Arkanoid.cambiarColores("anegda", "negro", "rojo", "rojo", "rojo");
		assertTrue(Config.BACKGROUND_COLOR.equals(Color.black));
		assertTrue(Config.BALL_COLOR.equals(Color.red));
		assertTrue(Config.BRICK_COLOR.equals(Color.red));
		assertTrue(Config.PADDLE_COLOR.equals(Color.red));
		String datos = Arkanoid.obtenerAjustes("anegda");
		assertTrue(datos.equalsIgnoreCase("negro rojo rojo rojo"));
	}
	
	@Test
	public void test1C() {
		//Esta prueba ya ha sido probada en el test0ABCD 
	}
	
	@Test
	public void test2A() {
		//cambiamos los colores de un usuario diferente simulando un login distinto
		Arkanoid.cambiarColores("urkazio", "azul", "azul", "azul", "azul");
		//comprobamos que los colores del usuario anegda sean los mismos que en la anterior prueba
		String datos = Arkanoid.obtenerAjustes("anegda");
		assertTrue(datos.equalsIgnoreCase("negro rojo rojo rojo"));
	}
	
	@Test
	public void test2B() {
		
	}

	//Los cambios de las pruebas 3A y 4A se aprecian en la interfaz de Ajustes 
	
	//Los cambios para la prueba 4B se guardan utilizando el método cambiarColores() que hemos estado utilizando 
	//correctamente para el resto de las pruebas

}