package br.com.SaveTheWorld.PlayerClasse;

public abstract class Classe {

	private int hp, mp, pf, pm, energia;

	//ATAQUES E MAGIAS
	
	public float atqBas(int fis, int mag){
	
		float dano = 0;
		
		if(fis >= mag){
			
			dano = ((fis*30)/100 + (mag*10)/100)/3;
			
		}else{
			
			dano = ((mag*30)/100 + (fis*10)/100)/3;
			
		}
		
		return dano;
		
	}
	
	//MÉTODOS GETTERS E SETTERS
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getPf() {
		return pf;
	}

	public void setPf(int pf) {
		this.pf = pf;
	}

	public int getPm() {
		return pm;
	}

	public void setPm(int pm) {
		this.pm = pm;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}
	
}
