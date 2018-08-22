package br.com.SaveTheWorld.Principal;

import java.util.ArrayList;

public class Loja {
	
	ArrayList<Item> itens = new ArrayList<Item>();
	
	//MÉTODO PARA A LOJA VENDER ITENS
	public ArrayList<Item> vendeItem(Item i){
		
		if(itens.contains(i)){
			itens.remove(i);
		}
		else{
			System.out.println("Item não está à venda");
		}
		
		return itens;
		
	}
	
	//MÉTODO PARA A LOJA COMPRAR ITENS
	public Loja compraItem(Loja l, Item i, ArrayList<Item> b){
		
		if(b.contains(i)){
			b.remove(i);
			l.itens.add(i);
		}
		else{
			System.out.println("Você não possui esse item!");
		}
		
		return l;
		
	}
	
	public Double descontaGold(Double gold, Double pGold){
		return (pGold - gold);	
	}
	
	
}
