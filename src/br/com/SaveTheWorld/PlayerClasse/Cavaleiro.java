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
		
		System.out.println("Meu Poder Mágico e toda sua beleza!! TANTUM LUMEN!!\n");
		
		if(dano <= 50){
			System.err.println("Esta é uma magia para iluminação que causa pouco dano na vista das pessoas");
		}else{
			System.err.println("Você é um cavaleiro com um poder mágico muito alto!!");
		}
		
		System.err.println("Dano causado: " + dano);
		
		return dano;
		
	}
	
	public float secans(int fis){
		
		float dano = (fis*40)/100;
		
		System.out.println("Não Sobrará nada! SECANS!");
		System.err.println("Dano causado: " + dano);
		
		return dano;
		
	}

}
