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
			System.err.println("Voc� � um mago, n�o devia sair por ai dando socos");
		}else{
			System.err.println("Voc� � realmente um mago com um soco poderoso!!");
		}
		
		System.err.println("Dano causado: " + dano);
		
		return dano;
		
	}
	
	public float inter(int mag){
		
		float dano = (mag*40)/100;
		
		System.out.println("Sinta sua destrui��o!! INTERITUM!");
		System.err.println("Dano causado: " + dano);
		
		return dano;
		
	}
	
}
