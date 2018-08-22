package br.com.SaveTheWorld.Principal;

public class Treino{

	public static Double descontaGold(Double gold, Double pGold){
		
		return (pGold - gold);
		
	}
	
	public static Integer descontaEn(Integer en, Integer pEn){
		
		return (pEn - en);
		
	}
	
	public static Integer treinoAtri(String opc, Player p){
		
		Integer at = 0;
		
		if("3".equals(opc)){

			at = (p.c.getPf()*(p.getLvl()+1))/100;
			at = p.c.getPf() + at;
		}
		else if("4".equals(opc)){
			
			at = (p.c.getPm()*(p.getLvl()+1))/100;
			at = p.c.getPm() + at;
		}
		
		return at;
		
	}
	
	public static Double treinoHP(Player p, Double hpMax){
		
		Double at = hpMax*p.getLvl()*0.07;
		
		return (at + hpMax);
		
	}
	
	public static Integer treinoMP(Player p, Integer mpMax){
		
		Integer at = mpMax*p.getLvl()*5/100;
		
		return (at + mpMax);
		
	}
	
	public static Integer treinoEn(Player p, Integer enMax){
		
		Integer at = enMax*5/100;
		
		return (at + enMax);
	}
}
