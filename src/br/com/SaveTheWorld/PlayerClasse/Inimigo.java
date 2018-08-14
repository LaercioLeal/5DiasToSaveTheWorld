package br.com.SaveTheWorld.PlayerClasse;

import br.com.SaveTheWorld.Principal.Player;

public class Inimigo {

	Double Hp;
	Integer Pf, Pm;
	private static Inimigo ini = new Inimigo();
	
	public static Inimigo CriaIni(Player p, String opc){
		
		Double aux;
		
		if(opc.equals("1") || opc.equalsIgnoreCase("Cavaleiro")){
			
			aux = (p.c.getHp()*1.6);
			ini.setHp(aux);
			ini.setPf(p.c.getPf() + (p.c.getPf()*10)/100);
			ini.setPm(p.c.getPm() + (p.c.getPm()*8)/100);
			
		}
		else if(opc.equals("2") || opc.equalsIgnoreCase("Mago")){

			aux = (p.c.getHp()*1.4);
			ini.setHp(aux);
			ini.setPf(p.c.getPf() + (p.c.getPf()*8)/100);
			ini.setPm(p.c.getPm() + (p.c.getPm()*10)/100);
			
		}
		else if(opc.equals("3") || opc.equalsIgnoreCase("Lutador")){

			aux = (p.c.getHp()*1.5);
			ini.setHp(aux);
			ini.setPf(p.c.getPf() + (p.c.getPf()*12)/100);
			ini.setPm(p.c.getPm() + (p.c.getPm()*10)/100);
			
		}
		else if(opc.equals("4") || opc.equalsIgnoreCase("Arqueiro")){

			aux = (p.c.getHp()*1.4);
			ini.setHp(aux);
			ini.setPf(p.c.getPf() + (p.c.getPf()*10)/100);
			ini.setPm(p.c.getPm() + (p.c.getPm()*10)/100);
			
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
	
	public Double Interitum(){
		
		Double dano = 0.0;
		Integer fis = ini.getPf();
		Integer mag = ini.getPm();
		
		dano = (fis*mag)/275.0;
		
		return dano;
		
	}
	
	public Double Mundi(){
		
		//Mundi Nuclear
		
		Double dano = 0.0;
		Integer fis = ini.getPf();
		Integer mag = ini.getPm();
		
		if(fis > mag){
			
			dano = (mag*3)/100.0;
			
		}
		else{
			
			dano = (fis*3)/100.0;
			
		}
		
		return dano;
		
	}
	
	public Double Vene(){
	
		//Veneficus Maledictus
	
		Double dano = 0.0;
		Integer fis = ini.getPf();
		Integer mag = ini.getPm();
		
		if(fis > mag){
			
			dano = (fis*15)/100.0;
			
		}
		else{
			
			dano = (mag*15)/100.0;
			
		}
		
		return dano;
		
	}

//MÉTODOS GETTERS E SETTERS

	public Double getHp() {
		return Hp;
	}

	public void setHp(Double hp) {
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
