package br.com.SaveTheWorld.PlayerClasse;

public class Arqueiro extends Classe {
	
	public Double sagSpi(Integer fis, Integer mag){
		
		//Sagittis Spiritualis
		
		Double dano = (fis*mag)/185.0;
		
		return dano;
		
	}
	
	public Double proin(Integer fis, Integer mag){
		
		Double dano = ((fis - mag)*3)/100.0;
		
		return dano;
		
	}
	
	public Double dupSag(Integer fis, Integer mag){
		
		//Duplex Sagittis
		
		Double dano = ((fis+mag)*30)/100.0;
		
		return dano;
		
	}

}
