package br.com.SaveTheWorld.Principal;

import java.util.ArrayList;

public class Loja {
	
	ArrayList<Item> itens = new ArrayList<Item>();
	
	//M�TODO PARA A LOJA VENDER ITENS
	public ArrayList<Item> vendeItem(Item i){
		
		if(itens.contains(i)){
			itens.remove(i);
		}
		else{
			System.out.println("Item n�o est� � venda");
		}
		
		return itens;
		
	}
	
	//M�TODO PARA A LOJA COMPRAR ITENS
	public Loja compraItem(Loja l, Item i, ArrayList<Item> b){
		
		if(b.contains(i)){
			b.remove(i);
			l.itens.add(i);
		}
		else{
			System.out.println("Voc� n�o possui esse item!");
		}
		
		return l;
		
	}
	
	public Double descontaGold(Double gold, Double pGold){
		return (pGold - gold);	
	}
	
	
}
