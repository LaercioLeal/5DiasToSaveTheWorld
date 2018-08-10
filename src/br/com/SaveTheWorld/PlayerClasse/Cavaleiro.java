package br.com.SaveTheWorld.PlayerClasse;

public class Cavaleiro extends Classe{
	
	public Double espMag(Integer fis, Integer mag){
		
		Double dano = (fis*mag)/120.0;
		
		return dano;
		
	}
	
	public Double lux(int mag){
		
		//Tantum Lumen
		
		Double dano = (mag*3)/100.0;
		
		return dano;
		
	}
	
	public Double secans(Integer fis){
		
		Double dano = (fis*40)/100.0;
		
		return dano;
		
	}

}
