package br.com.SaveTheWorld.PlayerClasse;

public class Mago extends Classe {

	public Double pot(Integer fis, Integer mag){
		
		Double dano = (fis*mag)/120.0;
		
		return dano;
		
	}
	
	public Double ferrum(Integer fis){
		
		Double dano = (fis*3)/100.0;
		
		return dano;
		
	}
	
	public Double inter(Integer mag){
		
		Double dano = (mag*40)/100.0;
		
		return dano;
		
	}
	
}
