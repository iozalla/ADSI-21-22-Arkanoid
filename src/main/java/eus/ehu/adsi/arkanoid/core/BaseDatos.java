package eus.ehu.adsi.arkanoid.core;

public class BaseDatos {
	private static BaseDatos miBD;
		
		//patron Singleton//
		public static BaseDatos getmiBD() {
			if(BaseDatos.miBD==null) {
				BaseDatos.miBD = new BaseDatos();
			}
			return(BaseDatos.miBD);
		}
}
