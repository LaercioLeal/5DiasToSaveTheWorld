package br.com.SaveTheWorld.PlayerClasse;

public class Lutador extends Classe {
	
	public float pugMag(int fis, int mag){
		
		float dano = (fis*mag)/100;
		
		System.out.println("Meu pode físico e mágico juntos! PUGNIS ET MAGIA!!");
		System.err.println("Dano causado: " + dano);
		
		return dano;
		
	}
	
	public float ictu(int mag){
		
		float dano = (mag*3)/100;
		
		System.out.println("Com um simples sopro eu posso acabar com você! ICTU!");
		
		if(dano <= 50){
			System.err.println("Você é um lutador, não deveria soprar os outros por ai...");
		}else{
			System.err.println("NOSSA! você tem um sopro realmente Poderoso!!");
		}
		
		System.err.println("Dano causado: " + dano);
		
		return dano;
		
	}
	
	public float pub(int fis){
		
		float dano = (fis*40)/100;
		
		System.out.println("Sinta o poder dos meus socos! PUGNIS SIMPLEX");
		System.err.println("Dano causado: " + dano);
		
		return dano;
		
	}

}
