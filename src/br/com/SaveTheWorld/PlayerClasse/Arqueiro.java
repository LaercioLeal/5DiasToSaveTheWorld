package br.com.SaveTheWorld.PlayerClasse;

public class Arqueiro extends Classe {
	
	public Double sagSpi(Integer fis, Integer mag){
		
		Double dano = (fis*mag)/120.0;
		
		System.out.println("Flechas m�gicas que podem perfurar qualquer coisa! SAGITTIS SPIRITUALIS!");
		System.err.println("Dano causado: " + dano);
		
		return dano;
		
	}
	
	public Double proin(Integer fis, Integer mag){
		
		Double dano = ((fis - mag)*3)/100.0;
		
		System.out.println("Uma Chuva m�gica que utiliza meu poder m�gico!! PROIN");
		
		if(dano <= 50){
			System.err.println("Voc� � um arqueiro, fazer chover realmente n�o � o seu forte...");
		}else{
			System.err.println("O Seu Chuvisco pode realmente virar uma tempestade!!");
		}
		
		System.err.println("Dano causado: " + dano);
		
		return dano;
		
	}
	
	public Double dupSag(Integer fis, Integer mag){
		
		Double dano = ((fis+mag)*30)/100.0;
		
		System.out.println("Nada pode Parar minhas Flechas Duplas!! DUPLEX SAGITTIS");
		System.err.println("Dano causado: " + dano);
		
		return dano;
		
	}

}
