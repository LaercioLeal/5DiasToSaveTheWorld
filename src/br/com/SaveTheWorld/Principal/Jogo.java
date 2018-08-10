package br.com.SaveTheWorld.Principal;

import java.text.DecimalFormat;
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
			
			cav.setHp(200.0);
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
			
			mago.setHp(120.0);
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
			
			lut.setHp(180.0);
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
			
			arq.setHp(150.0);
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
		
		Inimigo ini = new Inimigo();
		DecimalFormat df = new DecimalFormat("###,##0.00");
		
		System.out.println("Selecione Seu Inimigo: ");
		System.out.println("\t1-Ini1\t2-Ini2\t3-Ini3\t4-Ini4");
		
		opc = tcld.nextLine();
		
		ini = Inimigo.CriaIni(play, opc);
		Double dano = 0.0;
		
		Double Hp = play.c.getHp();
		Integer Mp = play.c.getMp();
		
		do{
			
			//Continuar pela simulação de luta
			
			System.out.println("Selecione seu Ataque: ");
			
			dano = Jogo.ExibeAtq(play, opc);
			
			dano = ini.getHp() - dano;
			
			ini.setHp(dano);
			
			if(play.c.getHp() <= 0){
				System.err.println("Oh, você Morreu!!");
			}
			else{
				System.err.println("Você tem: " + df.format(play.c.getHp()) + " de HP.");
				System.err.println("Seu inimigo tem: " + df.format(ini.getHp()) + " de Hp.");	
			}
			
		}while((play.c.getHp()<=0) || (ini.getHp()<=0));
		
		play.c.setHp(Hp);
		play.c.setMp(Mp);
		
		return play;
		
	}
	
	public static Double ExibeAtq(Player play, String opc){
		
		System.out.println("1-Ataque Básico");
		
		Double dano = 0.0;
		
		if("1".equals(opc)){
			
			dano = play.c.atqBas(play.c.getPf(), play.c.getPm());
			
		}
		else if(play.c instanceof Cavaleiro){
			
			Cavaleiro c = (Cavaleiro) play.getC();
			
			System.out.print("\t2-Magia Gladium\t3-Tantum Lumen\t4-Secans");
			
			opc = tcld.nextLine();
			
			if("2".equals(opc)){
				dano = c.espMag(c.getPf(), c.getPm());
				
				System.out.println("Sinta a magia da minha Espada! MAGIA GLADIUM!");
				
			}
			else if("3".equals(opc)){
				dano = c.lux(c.getPm());
				
				System.out.println("Meu Poder Mágico e toda sua beleza!! TANTUM LUMEN!!\n");
				
				if(dano <= 50){
					System.err.println("Esta é uma magia para iluminação que causa pouco dano na vista das pessoas");
				}else{
					System.err.println("Você é um cavaleiro com um poder mágico muito alto!!");
				}
				
			}
			else if("4".equals(opc)){
				dano = c.secans(c.getPf());
				
				System.out.println("O Poder do meu Cajado! POTENTIA!");
				
			}
			
		}
		else if(play.c instanceof Mago){
			
			Mago c = (Mago) play.getC();
			
			System.out.print("\t2-Potentia\t2-Ferrum\t3-Interitum");
			
			opc = tcld.nextLine();
			
			if("2".equals(opc)){
				dano = c.pot(c.getPf(), c.getPm());
				
				System.out.println("O Poder do meu Cajado! POTENTIA!");
			
			}
			else if("3".equals(opc)){
				dano = c.ferrum(c.getPf());
				
				System.out.println("Todo o Poder do meu Corpo! FERRUM!");
				
				if(dano <= 50){
					System.err.println("Você é um mago, não devia sair por ai dando socos");
				}else{
					System.err.println("Você é realmente um mago com um soco poderoso!!");
				}
				
			}
			else if("4".equals(opc)){
				dano = c.inter(c.getPm());
				
				System.out.println("Sinta sua destruição!! INTERITUM!");
				
			}
			
		}
		else if(play.c instanceof Lutador){
			
			Lutador c = (Lutador) play.getC();
			
			System.out.print("\t2-Pugnis et Magia\t2-Ictu\t3-Pugnis Simplex");
			
			opc = tcld.nextLine();
			
			if("2".equals(opc)){
				dano = c.pugMag(c.getPf(), c.getPm());
				
				System.out.println("Meu poder físico e mágico juntos! PUGNIS ET MAGIA!!");
				
			}
			else if("3".equals(opc)){
				dano = c.ictu(c.getPm());
				
				System.out.println("Com um simples sopro mágico eu posso acabar com você! ICTU!");
				
				if(dano <= 50){
					System.err.println("Você é um lutador, não deveria sair soprando os outros por ai...");
				}else{
					System.err.println("NOSSA! você tem um sopro realmente Poderoso!!");
				}
				
			}
			else if("4".equals(opc)){
				dano = c.pub(c.getPf());
				
				System.out.println("Sinta o poder dos meus socos! PUGNIS SIMPLEX");
				
			}
		}
		else if(play.c instanceof Arqueiro){
			
			Arqueiro c = (Arqueiro) play.getC();
			
			System.out.print("\t2-Sagittis Spiritualis\t2-Proin\t3-Duplex Sagittis");
			
			opc = tcld.nextLine();
			
			if("2".equals(opc)){
				dano = c.sagSpi(c.getPf(), c.getPm());
				
				System.out.println("Flechas mágicas que podem perfurar qualquer coisa! SAGITTIS SPIRITUALIS!");
				
			}
			else if("3".equals(opc)){
				dano = c.proin(c.getPf(), c.getPm());
				
				System.out.println("Uma Chuva mágica que utiliza meu poder mágico!! PROIN");
				
				if(dano <= 50){
					System.err.println("Você é um arqueiro, fazer chover realmente não é o seu forte...");
				}else{
					System.err.println("O Seu Chuvisco pode realmente virar uma tempestade!!");
				}
				
			}
			else if("4".equals(opc)){
				dano = c.dupSag(c.getPf(), c.getPm());
				
				System.out.println("Nada pode Parar minhas Flechas Duplas!! DUPLEX SAGITTIS");
				
			}
		}
		
		System.err.println("Dano causado: " + dano);
		
		return dano;
		
	}

}
