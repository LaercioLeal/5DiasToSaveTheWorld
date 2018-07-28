package br.com.SaveTheWorld.Principal;

import java.util.Scanner;

import br.com.SaveTheWorld.PlayerClasse.*;

public class Jogo {

	static Scanner tcld = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Player play;
		String opc;
		String nome;
		
		System.out.println("5DiasToSavetheWorld!!");
		System.out.println("\nSeja Bem-Vindo Jogador!");
		System.out.println("O que deseja fazer?");
		System.out.println("\t1-Come�ar Jogo\n\t2-Informa��es\n\t3-Sair");
		
		opc = tcld.nextLine();
		
		if(opc.equals("1")){
			
			System.out.println("Digite o Nome de seu Personagem: ");
			nome = tcld.nextLine();

			play = new Player(nome);
			
			System.out.println("Escolha a Classe desejada:");
			System.out.println("\n\t->Cavaleiro\n\t->Mago\n\t->Lutador\n\t->Arqueiro");
		
			opc = tcld.nextLine();
			
			play = Jogo.cria(opc, play);
			
			System.out.println("Nome: " + play.getNome() + "\tLevel: " + play.getLvl() + "\tExp: " + play.getExp() + "\tGold: " + play.getGold() + "\nEquipamentos: " + play.getEquip());
			System.out.println("Hp: " + play.c.getHp() + "\tMp: " + play.c.getMp() + "\tPf: " + play.c.getPf() + "\tPm: " + play.c.getPm() + "\tEnergia: " + play.c.getEnergia());
			
			play = Jogo.menuGame(play, opc);
			
			System.out.println("Nome: " + play.getNome() + "\tLevel: " + play.getLvl() + "\tExp: " + play.getExp() + "\tGold: " + play.getGold() + "\nEquipamentos: " + play.getEquip());
			System.out.println("Hp: " + play.c.getHp() + "\tMp: " + play.c.getMp() + "\tPf: " + play.c.getPf() + "\tPm: " + play.c.getPm() + "\tEnergia: " + play.c.getEnergia());
			
			
		}
		
		tcld.close();
		
	}
	
//MENU GAME QUE CONTROLA AS A��ES DO JOGADOR
	public static Player menuGame(Player play, String cat){
		
		do{
			System.out.println("\nOl�. O que deseja fazer agora?");
			System.out.println("\t1-Enfrentar meus Inimigos!\n\t2-Trabalhar");
			System.out.println("\t3-Treinar\n\t4-Ir a Loja\n\t5-Sair");
			
			cat = tcld.nextLine();
			
			if(cat.equals("1")){
				
			}
			else if(cat.equals("2")){
				
				Double remun;
				
				System.out.println("Como deseja trabalhar hoje?");
				System.out.println("\t->Padeiro\n\t->Professor\n\t->Vendedor\n\t->Policial\n\t->Politico\n\t->Voltar");
				
				cat = tcld.nextLine();
		
				remun = Trabalho.tipoTrab(cat, play.getLvl(), play.getExp());
				
				play.setGold(remun);
				
				System.out.println("Voc� agora tem: " + play.getGold() + " de gold!");
				
			}
			
		}while(!cat.equals("5"));
		
		return play;
		
	}
	
//M�TODO DE CRIA��O DE PERSONAGEM
	public static Player cria(String opc, Player play){
		
		if(opc.equalsIgnoreCase("Cavaleiro") || opc.equalsIgnoreCase("Cav")){

			Cavaleiro cav = new Cavaleiro();
			
			cav.setHp(200);
			cav.setMp(80);
			cav.setPf(180);
			cav.setPm(50);
			cav.setEnergia(180);
		
			play.setC(cav); //Altera o Atributo C (tipo Classe) para o novo tipo selecionado
					
			System.err.println("\nCavaleiro Criado!!");
		
			return play;
			
		}
		else if(opc.equalsIgnoreCase("Mago")){

			Mago mago = new Mago();
			
			mago.setHp(120);
			mago.setMp(200);
			mago.setPf(65);
			mago.setPm(175);
			mago.setEnergia(100);
			
			play.setC(mago); //Altera o Atributo C (tipo Classe) para o novo tipo selecionado
			
			System.err.println("\nMago Criado!!");
			
			return play;
		
		}
		else if(opc.equalsIgnoreCase("Lutador") || opc.equalsIgnoreCase("Lut")){

			Lutador lut = new Lutador();
			
			lut.setHp(180);
			lut.setMp(100);
			lut.setPf(165);
			lut.setPm(75);
			lut.setEnergia(150);
			
			play.setC(lut); //Altera o Atributo C (tipo Classe) para o novo tipo selecionado
			
			System.err.println("\nLutador Criado!!");
		
			return play;
		
		}
		else if(opc.equalsIgnoreCase("Arqueiro") || opc.equalsIgnoreCase("Arq")){

			Arqueiro arq = new Arqueiro();
			
			arq.setHp(150);
			arq.setMp(130);
			arq.setPf(150);
			arq.setPm(100);
			arq.setEnergia(200);
			
			play.setC(arq); //Altera o Atributo C (tipo Classe) para o novo tipo selecionado
			
			System.err.println("\nArqueiro Criado!!");
			
			return play;
		
		}
		
		return null;
	}
	
}