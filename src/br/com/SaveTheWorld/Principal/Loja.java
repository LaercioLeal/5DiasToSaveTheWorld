package br.com.SaveTheWorld.Principal;

import java.util.ArrayList;

public class Loja {
	
	ArrayList<Item> itens = new ArrayList<Item>();
	
	//M�TODO PARA ADICIONAR NA LOJA
	public ArrayList<Item> addItem(Item i){
		itens.add(i);
		return itens;
	}
	
	//M�TODO PARA A LOJA VENDER ITENS
	public ArrayList<Item> vendeItem(Item i){
		
		if(itens.contains(i)){
			itens.remove(i);
		}
		
		return itens;
		
	}
	
	//M�TODO PARA A LOJA COMPRAR ITENS
	public ArrayList<Item> compraItem(Item i, ArrayList<Item> b){
		
		if(b.contains(i)){
			itens.add(i);
		}
		
		return itens;
		
	}

	public Double descontaGold(Double gold, Double pGold){
		return (pGold - gold);	
	}

	//M�TODOS GETTERS E SETTERS
	public ArrayList<Item> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}
}
