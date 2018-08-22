package br.com.SaveTheWorld.PlayerClasse;

public class Lutador extends Classe {
	
	public Double pugMag(Integer fis, Integer mag){
		
		Double dano = (fis*mag)/160.0;
		
		return dano;
		
	}
	
	public Double ictu(Integer mag){
		
		Double dano = (mag*3)/100.0;
		
		return dano;
		
	}
	
	public Double pub(Integer fis){
		
		Double dano = (fis*40)/100.0;
		
		return dano;
		
	}

}
