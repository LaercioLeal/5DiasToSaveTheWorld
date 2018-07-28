package br.com.SaveTheWorld.Principal;

public abstract class Trabalho {
	
	private String cat;
	
	public static Double tipoTrab(String cat, Integer Lvl, Double exp){

		Double remun = 2.5;
		
		if("Padeiro".equalsIgnoreCase(cat)){
			
			remun = (0.75*exp)/Lvl;
			
			System.out.println("Parabéns por ser um Padeiro tão esforçado!\n");
			
		}
		else if("Professor".equalsIgnoreCase(cat)){
			
			remun = (0.15*exp)/Lvl;
			
			if(remun <= 200){
				System.out.println("É professor não uma profissão muito bem reconhecida...\n");
			}
			else{
				System.out.println("Uau você é um professor muito bem recompensado!!\n");
			}
			
		}
		else if("Vendedor".equalsIgnoreCase(cat)){
			
			remun = (0.90*exp)/Lvl;
			
			System.out.println("Você é um vendedor com uma comissão bem vantajosa...\n");
			
		}
		else if("Policial".equalsIgnoreCase(cat)){
			
			remun = (1.05*exp)/Lvl;
			
			System.out.println("Cuidado no caminho como Policial, nunca se pode imaginar quando você pode levar um tiro!\n");
			
		}
		else if("Politico".equalsIgnoreCase(cat)){
			remun = (2.5*exp)/Lvl;
			
			System.out.println("Você acabou se metendo em um esquema de Corrupção... Parabéns!!\nVocê é um excelente Político.\n");
			
		}
		
		System.err.println("Você conseguiu: " + remun + " de gold!!");
		
		return remun;
		
	}

//MÉTODOS GETTERS E SETTERS
	
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	
}
