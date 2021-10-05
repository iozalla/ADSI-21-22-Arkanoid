package eus.ehu.adsi.arkanoid.core;

public class Highscore {
	private static Highscore miHighScore;
		
		//patron Singleton//
		public static Highscore getMiHighScore() {
			if(Highscore.miHighScore==null) {
				Highscore.miHighScore = new Highscore();
			}
			return(Highscore.miHighScore);
		}
		
		public void mostrarScoreGlobal () {
			//filtradoJAVA8
		}
		
		public void mostrarPersonal () {
			//filtradoJAVA8
		}

		
}