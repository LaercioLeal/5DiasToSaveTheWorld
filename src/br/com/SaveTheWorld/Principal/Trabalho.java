package br.com.SaveTheWorld.Principal;

public abstract class Trabalho {
	
	public static Double calculoRemuneracao(Integer Lvl, Double exp){
		return exp/Lvl;
	}
	
	public static Integer descontaEnergia(Integer Lvl, Integer En){
		return En/(2*Lvl);
	}
	
}
