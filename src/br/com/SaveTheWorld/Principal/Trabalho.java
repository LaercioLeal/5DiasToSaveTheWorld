package br.com.SaveTheWorld.Principal;

public abstract class Trabalho {
	
	public static Double tipoTrab(String cat, Integer Lvl, Double exp){

		Double remun = 2.5;
		
		if("Padeiro".equalsIgnoreCase(cat) || "1".equals(cat)){
			
			remun = (0.75*exp)/Lvl;
			
			System.out.println("Parab�ns por ser um Padeiro t�o esfor�ado!\n");
			
		}
		else if("Professor".equalsIgnoreCase(cat) || "2".equals(cat)){
			
			remun = (0.15*exp)/Lvl;
			
			if(remun <= 200){
				System.out.println("� professor n�o uma profiss�o muito bem reconhecida...\n");
			}
			else{
				System.out.println("Uau voc� � um professor muito bem recompensado!!\n");
			}
			
		}
		else if("Vendedor".equalsIgnoreCase(cat) || "3".equals(cat)){
			
			remun = (0.90*exp)/Lvl;
			
			System.out.println("Voc� � um vendedor com uma comiss�o bem vantajosa...\n");
			
		}
		else if("Policial".equalsIgnoreCase(cat) || "4".equals(cat)){
			
			remun = (1.05*exp)/Lvl;
			
			System.out.println("Cuidado no caminho como Policial, nunca se pode imaginar quando voc� pode levar um tiro!\n");
			
		}
		else if("Politico".equalsIgnoreCase(cat) || "5".equals(cat)){
			remun = (2.5*exp)/Lvl;
			
			System.out.println("Voc� acabou se metendo em um esquema de Corrup��o... Parab�ns!!\nVoc� � um excelente Pol�tico.\n");
			
		}
		
		return remun;
		
	}
	
}
