package br.com.SaveTheWorld.PlayerClasse;

import br.com.SaveTheWorld.Principal.Player;

public class Inimigo {

	Integer Hp, Pf, Pm;
	private static Inimigo ini;
	
	public static Inimigo CriaIni(Player p, String opc){
		
		ini = null;
		
		if(opc.equals("1") || opc.equalsIgnoreCase("Cavaleiro")){
			
			ini.setHp(p.c.getHp()*3);
			ini.setPf(p.c.getPf() + (p.c.getPf()*30)/100);
			ini.setPm(p.c.getPm() + (p.c.getPm()*15)/100);
			
		}
		else if(opc.equals("2") || opc.equalsIgnoreCase("Mago")){
			
			ini.setHp(p.c.getHp()*3);
			ini.setPf(p.c.getPf() + (p.c.getPf()*15)/100);
			ini.setPm(p.c.getPm() + (p.c.getPm()*30)/100);
			
		}
		else if(opc.equals("3") || opc.equalsIgnoreCase("Lutador")){
			
			ini.setHp(p.c.getHp()*3);
			ini.setPf(p.c.getPf() + (p.c.getPf()*25)/100);
			ini.setPm(p.c.getPm() + (p.c.getPm()*20)/100);
			
		}
		else if(opc.equals("4") || opc.equalsIgnoreCase("Arqueiro")){
			
			ini.setHp(p.c.getHp()*3);
			ini.setPf(p.c.getPf() + (p.c.getPf()*25)/100);
			ini.setPm(p.c.getPm() + (p.c.getPm()*25)/100);
			
		}
		
		return ini;
		
	}

	
//MÉTODOS DE ATAQUES
	
	public Double AtqBas(){
	
		Double dano = 0.0;
		Integer fis = ini.getPf();
		Integer mag = ini.getPm();
		
		if(fis >= mag){
			
			dano = (((fis*30)/100 + (mag*10)/100)/3.0);
			
		}else{
			
			dano = (((mag*30)/100 + (fis*10)/100)/3.0);
			
		}
		
		return dano;
		
	}
	
//MÉTODOS GETTERS E SETTERS

	public Integer getHp() {
		return Hp;
	}

	public void setHp(Integer hp) {
		Hp = hp;
	}

	public Integer getPf() {
		return Pf;
	}

	public void setPf(Integer pf) {
		Pf = pf;
	}

	public Integer getPm() {
		return Pm;
	}

	public void setPm(Integer pm) {
		Pm = pm;
	}

	
	
}
