package br.com.SaveTheWorld.PlayerClasse;

public class Lutador extends Classe {
	
	public Double pugMag(Integer fis, Integer mag){
		
		Double dano = (fis*mag)/120.0;
		
		System.out.println("Meu poder físico e mágico juntos! PUGNIS ET MAGIA!!");
		System.err.println("Dano causado: " + dano);
		
		return dano;
		
	}
	
	public Double ictu(Integer mag){
		
		Double dano = (mag*3)/100.0;
		
		System.out.println("Com um simples sopro mágico eu posso acabar com você! ICTU!");
		
		if(dano <= 50){
			System.err.println("Você é um lutador, não deveria sair soprando os outros por ai...");
		}else{
			System.err.println("NOSSA! você tem um sopro realmente Poderoso!!");
		}
		
		System.err.println("Dano causado: " + dano);
		
		return dano;
		
	}
	
	public Double pub(Integer fis){
		
		Double dano = (fis*40)/100.0;
		
		System.out.println("Sinta o poder dos meus socos! PUGNIS SIMPLEX");
		System.err.println("Dano causado: " + dano);
		
		return dano;
		
	}

}
