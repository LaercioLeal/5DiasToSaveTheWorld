package br.com.SaveTheWorld.Principal;

import java.util.ArrayList;

public class Loja {
	
	ArrayList<Item> itens = new ArrayList<>();
	
	//MÉTODO PARA ADICIONAR NA LOJA
	public void addItem(Item i){
		itens.add(i);
	}
	
	//MÉTODO PARA A LOJA VENDER ITENS
	public void vendeItem(Item i){
		
		if(itens.contains(i)){
			itens.remove(i);
		}
		
	}
	
	//MÉTODO PARA A LOJA COMPRAR ITENS
	public void compraItem(Item i, ArrayList<Item> b){
		
		if(b.contains(i)){
			itens.add(i);
		}
		
	}
	
	//MÉTODO PARA DESCONTAR GOLD DO JOGADOR
	public Double descontaGold(Double gold, Double pGold){
		return (pGold - gold);	
	}
	
	//MÉTODO PARA O JOGADOR RECEBER GOLD
	public Double recebeGold(Double gold, Double pGold){
		return (pGold + gold);	
	}
	
	//MÉTODOS GETTERS E SETTERS
	public ArrayList<Item> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}
	
	//MÉTODO PARA ENCONTRAR INDEX
	public Integer getIndex(Integer id){
		
		Integer index = null;
		
		for(Item i: itens){
			if(i.getId() == id){
				index = itens.indexOf(i);
			}
		}
		return index;
	}
	
}
