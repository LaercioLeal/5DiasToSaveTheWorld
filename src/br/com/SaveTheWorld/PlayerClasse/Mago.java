package br.com.SaveTheWorld.PlayerClasse;

public class Mago extends Classe {

	public float pot(int fis, int mag){
		
		float dano = (fis*mag)/120;
		
		System.out.println("O Poder do meu Cajado! POTENTIA!");
		System.err.println("Dano causado: " + dano);
		
		return dano;
		
	}
	
	public float ferrum(int fis){
		
		float dano = (fis*3)/100;
		
		System.out.println("Todo o Poder do meu Corpo! FERRUM!");
		
		if(dano <= 50){
			System.err.println("Você é um mago, não devia sair por ai dando socos");
		}else{
			System.err.println("Você é realmente um mago com um soco poderoso!!");
		}
		
		System.err.println("Dano causado: " + dano);
		
		return dano;
		
	}
	
	public float inter(int mag){
		
		float dano = (mag*40)/100;
		
		System.out.println("Sinta sua destruição!! INTERITUM!");
		System.err.println("Dano causado: " + dano);
		
		return dano;
		
	}
	
}
