package br.com.SaveTheWorld.Principal;

import java.util.ArrayList;

import br.com.SaveTheWorld.PlayerClasse.*;

public class Player {

	private String nome;
	private Double gold;
	private Integer Lvl;
	private Double Exp;
	private Item equip;
	public Classe c;
	private ArrayList<Item> bag = new ArrayList<Item>();

//CONSTRUCTOR DA CLASSE
	public Player(String nome){
		this.nome = nome;
		this.gold = 150.0;
		this.Lvl = 1;
		this.Exp = 5.0;
		this.equip = new Item(null, "Oh! Você está Nú", null, 0, null, 0.0);
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
		this.gold = gold;
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
	public Item getEquip() {
		return equip;
	}
	public String getEquipNome(){
		return equip.getNome();
	}
	public void setEquip(Item equip) {

		this.equip = equip;
		
		if(equip.getTipo().equalsIgnoreCase("Fisico")){
			this.c.setPf(c.getPf() + equip.getAtributo());
		}
		else if(equip.getTipo().equalsIgnoreCase("Magico")){
			this.c.setPm(c.getPm() + equip.getAtributo());
		}
		else if(equip.getTipo().equalsIgnoreCase("HP")){
			this.c.setHp(c.getHp() + equip.getAtributo());
		}
		else if(equip.getTipo().equalsIgnoreCase("MP")){
			this.c.setMp(c.getMp() + equip.getAtributo());
		}
		else if(equip.getTipo().equalsIgnoreCase("HP/Fisico")){
			this.c.setPf(c.getPf() + equip.getAtributo());
			this.c.setHp(c.getHp() + equip.getAtributo());
		}
		else if(equip.getTipo().equalsIgnoreCase("HP/Magico")){
			this.c.setPm(c.getPm() + equip.getAtributo());
			this.c.setHp(c.getHp() + equip.getAtributo());
		}
		else if(equip.getTipo().equalsIgnoreCase("Fisico/Magico")){
			this.c.setPm(c.getPm() + equip.getAtributo());
			this.c.setPf(c.getPf() + equip.getAtributo());
		}
		else if(equip.getTipo().equalsIgnoreCase("HP/MP")){
			this.c.setMp(c.getMp() + equip.getAtributo());
			this.c.setHp(c.getHp() + equip.getAtributo());
		}
	}
	public Classe getC() {
		return c;
	}
	public ArrayList<Item> getBag() {
		return bag;
	}
	public void setBag(ArrayList<Item> bag) {
		this.bag = bag;
	}
	
//MÉTODO PARA DESEQUIPAR ITEM
	public void removeEquip() {
		
		if(equip.getTipo().equalsIgnoreCase("Fisico")){
			this.c.setPf(c.getPf() - equip.getAtributo());
		}
		else if(equip.getTipo().equalsIgnoreCase("Magico")){
			this.c.setPm(c.getPm() - equip.getAtributo());
		}
		else if(equip.getTipo().equalsIgnoreCase("HP")){
			this.c.setHp(c.getHp() - equip.getAtributo());
		}
		else if(equip.getTipo().equalsIgnoreCase("MP")){
			this.c.setMp(c.getMp() - equip.getAtributo());
		}
		else if(equip.getTipo().equalsIgnoreCase("HP/Fisico")){
			this.c.setPf(c.getPf() - equip.getAtributo());
			this.c.setHp(c.getHp() - equip.getAtributo());
		}
		else if(equip.getTipo().equalsIgnoreCase("HP/Magico")){
			this.c.setPm(c.getPm() - equip.getAtributo());
			this.c.setHp(c.getHp() - equip.getAtributo());
		}
		else if(equip.getTipo().equalsIgnoreCase("Fisico/Magico")){
			this.c.setPm(c.getPm() - equip.getAtributo());
			this.c.setPf(c.getPf() - equip.getAtributo());
		}
		else if(equip.getTipo().equalsIgnoreCase("HP/MP")){
			this.c.setMp(c.getMp() - equip.getAtributo());
			this.c.setHp(c.getHp() - equip.getAtributo());
		}
		
		equip = new Item(null, "Oh! Você está Nú", null, 0, null, 0.0);
		
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

//VERIFICAÇÃO E CÁLCULO DE EXP
	public Integer nextLvl(){
		
		Integer nextLvl;
		
		if( Lvl <= 8){
			nextLvl = 85*Lvl;	
		}
		else if(Lvl > 8 && Lvl <= 20){
			nextLvl = 115*Lvl;
		}
		else{
			nextLvl = 145*Lvl;
		}
		
		return nextLvl;
		
	}
	
	public Integer verificaExp(Player play){
		
		Integer nextLvl = play.nextLvl();
		Integer ret = 0;
		Double hp = play.c.getHp();
		Integer mp = play.c.getMp();
		Integer pf = play.c.getPf();
		Integer pm = play.c.getPm();
		Integer en = play.c.getEnergia();
		
		if(Exp >= nextLvl){
			
			hp = hp + hp*0.1;
			mp = mp + (mp*10)/100;
			pf = pf + (pf*5)/100;
			pm = pm + (pm*5)/100;
			en = en + (en*5)/100;
			
			play.setLvl(Lvl + 1);
			play.c.setHp(hp);
			play.c.setMp(mp);
			play.c.setPf(pf);
			play.c.setPm(pm);
			play.c.setEnergia(en);
			
			ret = 1;
		}
		
		return ret;
		
	}
	
	//PEGANDO INDEX DO ITEM NA BAG
	public Integer getIndex(Integer id){
		
		Integer index = null;
		
		for(Item i: bag){
			if(i.getId() == id){
				index = bag.indexOf(i);
			}
		}
		return index;
	}

}
