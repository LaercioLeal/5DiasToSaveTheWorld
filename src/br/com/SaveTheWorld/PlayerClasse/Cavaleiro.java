package br.com.SaveTheWorld.PlayerClasse;

public class Cavaleiro extends Classe{
	
	public float EspMag(int fis, int mag){
		
		float dano = (fis*mag)/120;
		
		System.out.println("Sinta minha Espada! MAGIA GLADIUM!");
		System.err.println("Dano causado: " + dano);
		
		return dano;
		
	}
	
	public float lux(int mag){
		
		float dano = (mag*3)/100;
		
		System.out.println("Meu Poder M�gico e toda sua beleza!! TANTUM LUMEN!!\n");
		
		if(dano <= 50){
			System.err.println("Esta � uma magia para ilumina��o que causa pouco dano na vista das pessoas");
		}else{
			System.err.println("Voc� � um cavaleiro com um poder m�gico muito alto!!");
		}
		
		System.err.println("Dano causado: " + dano);
		
		return dano;
		
	}
	
	public float secans(int fis){
		
		float dano = (fis*40)/100;
		
		System.out.println("N�o Sobrar� nada! SECANS!");
		System.err.println("Dano causado: " + dano);
		
		return dano;
		
	}

}
