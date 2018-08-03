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
		System.out.println("\t1-Começar\n\t2-Informações\n\t3-Sair");
		
		opc = tcld.nextLine();
		
		if(opc.equals("1") || opc.equalsIgnoreCase("Começar")){
			
			System.out.println("Digite o Nome de seu Personagem: ");
			nome = tcld.nextLine();

			play = new Player(nome);
			
			System.out.println("Escolha a Classe desejada:");
			System.out.println("\n\t1-Cavaleiro\n\t2-Mago\n\t3-Lutador\n\t4-Arqueiro");
		
			opc = tcld.nextLine();
			
			play = Jogo.cria(play, opc);
			
			System.out.println("Nome: " + play.getNome() + "\tLevel: " + play.getLvl() + "\tExp: " + play.getExp() + "\tGold: " + play.getGold() + "\nEquipamentos: " + play.getEquip());
			System.out.println("Hp: " + play.c.getHp() + "\tMp: " + play.c.getMp() + "\tPf: " + play.c.getPf() + "\tPm: " + play.c.getPm() + "\tEnergia: " + play.c.getEnergia());
			
			do{
				System.out.println("\nOlá. O que deseja fazer agora?");
				System.out.println("\t1-Enfrentar meus Inimigos(LUTAR)!\n\t2-Trabalhar");
				System.out.println("\t3-Treinar\n\t4-Ir a Loja\n\t5-Sair");
				
				opc = tcld.nextLine();
				
				if(opc.equals("1") || opc.equalsIgnoreCase("Lutar")){
					
					System.out.println("Selecione Seu Inimigo: ");
					System.out.println("\t1-Ini1\t2-Ini2\t3-Ini3\t4-Ini4");
					
					opc = tcld.nextLine();
					
					play = Jogo.hist(play, opc);
					
				}
				else if(opc.equals("2") || opc.equalsIgnoreCase("Trabalhar")){
					
					play = Jogo.trabalho(play, opc);
					
				}
				
			}while(!opc.equals("5"));
			
			System.out.println("Nome: " + play.getNome() + "\tLevel: " + play.getLvl() + "\tExp: " + play.getExp() + "\tGold: " + play.getGold() + "\nEquipamentos: " + play.getEquip());
			System.out.println("Hp: " + play.c.getHp() + "\tMp: " + play.c.getMp() + "\tPf: " + play.c.getPf() + "\tPm: " + play.c.getPm() + "\tEnergia: " + play.c.getEnergia());
			
			
		}
		
		tcld.close();
		
	}
	
//MENU GAME QUE CONTROLA AS AÇÕES DO JOGADOR
	public static Player trabalho(Player play, String cat){
		
		Double remun;
		
		System.out.println("Como deseja trabalhar hoje?");
		System.out.println("\t1-Padeiro\n\t2-Professor\n\t3-Vendedor\n\t4-Policial\n\t5-Politico\n\t6-Voltar");
		
		cat = tcld.nextLine();
		if(cat.equals("6")){
			System.out.println("Até mais!!");
		}else{

			remun = Trabalho.tipoTrab(cat, play.getLvl(), play.getExp());
			play.setGold(remun);
			System.err.println("Você agora tem: " + play.getGold() + " de gold!");
				
		}
				
		return play;
		
	}
	
//MÉTODO DE CRIAÇÃO DE PERSONAGEM
	public static Player cria(Player play, String opc){
		
		if(opc.equalsIgnoreCase("Cavaleiro") || opc.equalsIgnoreCase("Cav") || opc.equals("1")){

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
		else if(opc.equalsIgnoreCase("Mago") || opc.equals("2")){

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
		else if(opc.equalsIgnoreCase("Lutador") || opc.equalsIgnoreCase("Lut") || opc.equals("3")){

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
		else if(opc.equalsIgnoreCase("Arqueiro") || opc.equalsIgnoreCase("Arq") || opc.equals("4")){

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
	
	public static Player hist(Player play, String opc){
		
		Inimigo Ini = new Inimigo();
		Ini = Inimigo.CriaIni(play, opc);
		
		Integer Hp = play.c.getHp();
		Integer Mp = play.c.getMp();
		
		do{
			
			//Continuar pelo a simulação de luta
			
		}while((play.c.getHp()!=0) || (Ini.getHp()!=0));
		
		play.c.setHp(Hp);
		play.c.setMp(Mp);
		
		return play;
		
	}
}
