package br.com.SaveTheWorld.Principal;

import java.util.Random;

import br.com.SaveTheWorld.PlayerClasse.*;

public class Historia{
	
	public Double IniAtq(Inimigo ini){
		
		Random r = new Random();
		Integer opc = r.nextInt(5)+1;
		Double dano = null;
		
		if(opc.equals(1)){
			
			System.out.println("SINTA O PODER DO MEU ATAQUE!");
			dano = ini.AtqBas();
			
			System.err.println("Você sofreu " + dano + " de dano");
			
		}
		
		return dano;
		
	}

}
