package br.com.SaveTheWorld.PlayerClasse;

public class Cavaleiro extends Classe{
	
	public Double espMag(Integer fis, Integer mag){
		
		Double dano = (fis*mag)/120.0;
		
		System.out.println("Sinta a magia da minha Espada! MAGIA GLADIUM!");
		System.err.println("Dano causado: " + dano);
		
		return dano;
		
	}
	
	public Double lux(int mag){
		
		Double dano = (mag*3)/100.0;
		
		System.out.println("Meu Poder M�gico e toda sua beleza!! TANTUM LUMEN!!\n");
		
		if(dano <= 50){
			System.err.println("Esta � uma magia para ilumina��o que causa pouco dano na vista das pessoas");
		}else{
			System.err.println("Voc� � um cavaleiro com um poder m�gico muito alto!!");
		}
		
		System.err.println("Dano causado: " + dano);
		
		return dano;
		
	}
	
	public Double secans(Integer fis){
		
		Double dano = (fis*40)/100.0;
		
		System.out.println("N�o Sobrar� nada! SECANS!");
		System.err.println("Dano causado: " + dano);
		
		return dano;
		
	}

}
