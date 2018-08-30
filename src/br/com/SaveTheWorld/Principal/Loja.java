package br.com.SaveTheWorld.Principal;

import java.util.ArrayList;

public class Loja {
	
	ArrayList<Item> itens = new ArrayList<>();
	
	//M�TODO PARA ADICIONAR NA LOJA
	public void addItem(Item i){
		itens.add(i);
	}
	
	//M�TODO PARA A LOJA VENDER ITENS
	public void vendeItem(Item i){
		
		if(itens.contains(i)){
			itens.remove(i);
		}
		
	}
	
	//M�TODO PARA A LOJA COMPRAR ITENS
	public void compraItem(Item i, ArrayList<Item> b){
		
		if(b.contains(i)){
			itens.add(i);
		}
		
	}
	
	//M�TODO PARA DESCONTAR GOLD DO JOGADOR
	public Double descontaGold(Double gold, Double pGold){
		return (pGold - gold);	
	}
	
	//M�TODO PARA O JOGADOR RECEBER GOLD
	public Double recebeGold(Double gold, Double pGold){
		return (pGold + gold);	
	}
	
	//M�TODOS GETTERS E SETTERS
	public ArrayList<Item> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}
	
	//M�TODO PARA ENCONTRAR INDEX
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
