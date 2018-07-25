package br.com.SaveTheWorld.Principal;

import java.util.Scanner;

import br.com.SaveTheWorld.PlayerClasse.*;

public class Jogo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner tcld = new Scanner(System.in);
		
		String opc;
		
		System.out.println("5DiasToSavetheWorld!!");
		System.out.println("\nSeja Bem-Vindo Jogador!");
		System.out.println("O que deseja fazer?");
		System.out.println("\t1-Começar Jogo\n\t2-Informações\n\t3-Sair");
		
		opc = tcld.nextLine();
		
		if(opc.intern() == "1"){
			System.out.println("Escolha a Classe desejada:");
			System.out.println("\n\t1-Cavaleiro\n\t2-Mago\n\t3-Lutador\n\t4-Arqueiro");
			
			opc = tcld.nextLine();
			
		}
		
		tcld.close();
		

	}
	
	public static Classe cria(String opc){
		
		if(opc.intern() == "1"){

			Cavaleiro cav = new Cavaleiro();
			
			cav.setHp(200);
			cav.setMp(80);
			cav.setPf(180);
			cav.setPm(50);
			cav.setEnergia(180);
			
			int hp = cav.getHp();
			int mp = cav.getMp();
			int pf = cav.getPf();
			int pm = cav.getPm();
			int energia = cav.getEnergia();
			
			System.err.println("\nCavaleiro Criado!!");
			System.out.println("Hp:" + hp + "Mp:" + mp + "Pf:" + pf + "Pm:" + pm + "Energia:" + energia);
			
			return cav;
			
		}else if(opc.intern() == "2"){

			Mago mago = new Mago();
			
			mago.setHp(120);
			mago.setMp(200);
			mago.setPf(65);
			mago.setPm(175);
			mago.setEnergia(100);
			
			int hp = mago.getHp();
			int mp = mago.getMp();
			int pf = mago.getPf();
			int pm = mago.getPm();
			int energia = mago.getEnergia();
			
			System.err.println("\nMago Criado!!");
			System.out.println("Hp:" + hp + "Mp:" + mp + "Pf:" + pf + "Pm:" + pm + "Energia:" + energia);
			
			return mago;
		
		}else if(opc.intern() == "3"){

			Lutador lut = new Lutador();
			
			lut.setHp(180);
			lut.setMp(100);
			lut.setPf(165);
			lut.setPm(75);
			lut.setEnergia(150);
			
			int hp = lut.getHp();
			int mp = lut.getMp();
			int pf = lut.getPf();
			int pm = lut.getPm();
			int energia = lut.getEnergia();
			
			System.err.println("\nLutador Criado!!");
			System.out.println("Hp:" + hp + "Mp:" + mp + "Pf:" + pf + "Pm:" + pm + "Energia:" + energia);
			
			return lut;
		
		}else if(opc.intern() == "4"){

			Arqueiro arq = new Arqueiro();
			
			arq.setHp(150);
			arq.setMp(130);
			arq.setPf(150);
			arq.setPm(100);
			arq.setEnergia(200);
			
			int hp = arq.getHp();
			int mp = arq.getMp();
			int pf = arq.getPf();
			int pm = arq.getPm();
			int energia = arq.getEnergia();
			
			System.err.println("\nArqueiro Criado!!");
			System.out.println("Hp:" + hp + "Mp:" + mp + "Pf:" + pf + "Pm:" + pm + "Energia:" + energia);
			
			return arq;
		
		}
		
		return null;
	}

}
