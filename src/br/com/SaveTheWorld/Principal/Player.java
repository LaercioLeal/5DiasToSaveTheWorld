package br.com.SaveTheWorld.Principal;

import br.com.SaveTheWorld.PlayerClasse.*;

public class Player {

	private String nome;
	private Double gold;
	private Integer Lvl;
	private Double Exp;
	private String equip;
	public Classe c;

//CONSTRUCTOR DA CLASSE
	public Player(String nome){
		this.nome = nome;
		this.gold = 150.0;
		this.Lvl = 1;
		this.Exp = 5.0;
		this.setEquip("Ó você está nú!");
		
	}
	
//MÉTODOS GETTERS E SETTERS
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getGold() {
		return gold;
	}
	public void setGold(Double gold) {
		this.gold += gold;
	}
	public Integer getLvl() {
		return Lvl;
	}
	public void setLvl(Integer lvl) {
		Lvl = lvl;
	}
	public Double getExp() {
		return Exp;
	}
	public void setExp(Double Exp) {
		this.Exp = Exp;
	}
	public String getEquip() {
		return equip;
	}
	public void setEquip(String equip) {
		this.equip = equip;
	}
	public Classe getC() {
		return c;
	}
	
//MÉTODO PARA SETAR A CLASSE SELECIONADA
	public void setC(Classe c) {
		
		if(c instanceof Cavaleiro){
			c = (Cavaleiro) c;
		}
		else if(c instanceof Mago){
			c = (Mago) c;
		}
		else if(c instanceof Lutador){
			c = (Lutador) c;
		}
		else if(c instanceof Arqueiro){
			c = (Arqueiro) c;
		}
		this.c = c;
	}
	
}
