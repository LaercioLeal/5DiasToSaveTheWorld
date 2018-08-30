package br.com.SaveTheWorld.PlayerClasse;

public abstract class Classe {

	private Integer mp, mpMax, pf, pm, energia, energiaMax;
	private Double hp, hpMax;
	
	//ATAQUES E MAGIAS
	
	public Double atqBas(Integer fis, Integer mag){

		Double dano = 0.0;
		
		if(fis >= mag){
			
			dano = (((fis*30)/100 + (mag*10)/100)/3.0);
			
		}else{
			
			dano = (((mag*30)/100 + (fis*10)/100)/3.0);
			
		}
		
		return dano;
		
	}
	
	//MÉTODOS GETTERS E SETTERS
	public Double getHp() {
		return hp;
	}

	public void setHp(Double hp) {
		this.hp = hp;
	}

	public Integer getMp() {
		return mp;
	}

	public void setMp(Integer mp) {
		this.mp = mp;
	}

	public Integer getPf() {
		return pf;
	}

	public void setPf(Integer pf) {
		this.pf = pf;
	}

	public Integer getPm() {
		return pm;
	}

	public void setPm(Integer pm) {
		this.pm = pm;
	}

	public Integer getEnergia() {
		return energia;
	}

	public void setEnergia(Integer energia) {
		this.energia = energia;
	}

	public Integer getMpMax() {
		return mpMax;
	}

	public void setMpMax(Integer mpMax) {
		this.mpMax = mpMax;
	}

	public Integer getEnergiaMax() {
		return energiaMax;
	}

	public void setEnergiaMax(Integer energiaMax) {
		this.energiaMax = energiaMax;
	}

	public Double getHpMax() {
		return hpMax;
	}

	public void setHpMax(Double hpMax) {
		this.hpMax = hpMax;
	}
	
}
