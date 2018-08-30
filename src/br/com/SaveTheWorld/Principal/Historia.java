package br.com.SaveTheWorld.Principal;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

import br.com.SaveTheWorld.PlayerClasse.*;

public class Historia{
	
	static Scanner tcld = new Scanner(System.in);
	
	public static Double IniAtq(Inimigo ini){
		
		Random r = new Random();
		Integer opc = r.nextInt(4)+1;
		Double dano = null;
		
		if(opc.equals(1)){
			
			System.out.println("Inimigo: SINTA O PODER DO MEU ATAQUE!");
			dano = ini.AtqBas();
			
		}
		else if(opc.equals(2)){
			
			System.out.println("Inimigo: Eu aniquilarei sua exist�ncia! INTERITUM!!");
			dano = ini.Interitum();
			
		}
		else if(opc.equals(3)){
			
			System.out.println("Inimigo: Mostrarei Todo o meu Poder Nuclear! MUNDI NUCLEAR AHAHAAHAH!!");
			dano = ini.Mundi();
			
		}
		else if(opc.equals(4)){
			
			System.out.println("Inimigo: Eu amaldi�oo a sua existencia ser insolente! VENEFICUS MALEDICTUS!");
			dano = ini.Vene();
			
		}
		
		return dano;
		
	}

	public static Double ExibeAtq(Player play, String opc){
		
		DecimalFormat df = new DecimalFormat("###,##0.00");
		
		Double dano = 0.0;
		
		Integer mp = play.c.getMp();
		
		if(play.c instanceof Cavaleiro){
			
			Cavaleiro c = (Cavaleiro) play.getC();
			
			System.out.print("1-Ataque B�sico\t2-Magia Gladium\t3-Tantum Lumen\t4-Secans\n");
			
			opc = tcld.nextLine();
			
			if("1".equals(opc)){
				
				dano = play.c.atqBas(play.c.getPf(), play.c.getPm());
				
			}
			else if("2".equals(opc) && (mp - 25) >= 0){
				
				dano = c.espMag(c.getPf(), c.getPm());
				
				play.c.setMp(mp - 25);
				
				System.out.println("\n" + play.getNome() + ": Sinta a magia da minha Espada! MAGIA GLADIUM!");
				
			}
			else if("3".equals(opc) && (mp - 10) >= 0){
				
				dano = c.lux(c.getPm());
				
				play.c.setMp(mp - 10);
				
				System.out.println("\n" + play.getNome() + ": Meu Poder M�gico e toda sua beleza!! TANTUM LUMEN!!\n");
				
				if(dano <= 50){
					System.err.println("Esta � uma magia para ilumina��o que causa pouco dano na vista das pessoas");
				}else{
					System.err.println("Voc� � um cavaleiro com um poder m�gico muito alto!!");
				}
				
			}
			else if("4".equals(opc)){
				dano = c.secans(c.getPf());
				
				System.out.println("\n" + play.getNome() + ": Voc� sofrer� com minha espada. SECANS!");
				
			}
			else{
				
				System.err.println("Voc� n�o tem mana Suficiente!");
				
			}
			
		}
		else if(play.c instanceof Mago){
			
			Mago c = (Mago) play.getC();
			
			System.out.print("1-Ataque B�sico\t2-Potentia\t3-Ferrum\t4-Interitum\n");
			
			opc = tcld.nextLine();
			
			if("1".equals(opc)){
				
				dano = play.c.atqBas(play.c.getPf(), play.c.getPm());
				
			}
			else if("2".equals(opc) && (mp-20) >= 0 ){
				
				dano = c.pot(c.getPf(), c.getPm());
				
				play.c.setMp(mp-20);
				
				System.out.println("\n" + play.getNome() + ": O Poder do meu Cajado! POTENTIA!");
			
			}
			else if("3".equals(opc)){
				
				dano = c.ferrum(c.getPf());
				
				System.out.println("\n" + play.getNome() + ": Todo o Poder do meu Corpo! FERRUM!");
				
				if(dano <= 50){
					System.err.println("Voc� � um mago, n�o devia sair por ai dando socos");
				}else{
					System.err.println("Voc� � realmente um mago com um soco poderoso!!");
				}
				
			}
			else if("4".equals(opc) && (mp-30) >= 0){
				
				dano = c.inter(c.getPm());
				
				play.c.setMp(mp - 30);
				
				System.out.println("\n" + play.getNome() + ": Sinta sua destrui��o!! INTERITUM!");
				
			}
			else{
				
				System.err.println("Voc� n�o tem mana Suficiente!");
				
			}
			
		}
		else if(play.c instanceof Lutador){
			
			Lutador c = (Lutador) play.getC();
			
			System.out.print("1-Ataque B�sico\t2-Pugnis et Magia\t3-Ictu\t4-Pugnis Simplex\n");
			
			opc = tcld.nextLine();
			
			if("1".equals(opc)){
				
				dano = play.c.atqBas(play.c.getPf(), play.c.getPm());
				
			}
			else if("2".equals(opc) && (mp - 25) >= 0){
				
				dano = c.pugMag(c.getPf(), c.getPm());
				
				play.c.setMp(mp - 25);
				
				System.out.println("\n" + play.getNome() + ": Meu poder f�sico e m�gico juntos! PUGNIS ET MAGIA!!");
				
			}
			else if("3".equals(opc) && (mp - 10) >= 0){
				
				dano = c.ictu(c.getPm());
				
				play.c.setMp(mp - 10);
				
				System.out.println("\n" + play.getNome() + ": Com um simples sopro m�gico eu posso acabar com voc�! ICTU!");
				
				if(dano <= 50){
					System.err.println("Voc� � um lutador, n�o deveria sair soprando os outros por ai...");
				}else{
					System.err.println("NOSSA! voc� tem um sopro realmente Poderoso!!");
				}
				
			}
			else if("4".equals(opc)){
				
				dano = c.pub(c.getPf());
				
				System.out.println("\n" + play.getNome() + ": Sinta o poder dos meus socos! PUGNIS SIMPLEX");
				
			}
			else{
				
				System.err.println("Voc� n�o tem mana Suficiente!");
				
			}
		}
		else if(play.c instanceof Arqueiro){
			
			Arqueiro c = (Arqueiro) play.getC();
			
			System.out.print("1-Ataque B�sico\t2-Sagittis Spiritualis\t3-Proin\t4-Duplex Sagittis\n");
			
			opc = tcld.nextLine();
			
			if("1".equals(opc)){
				
				dano = play.c.atqBas(play.c.getPf(), play.c.getPm());
				
			}
			else if("2".equals(opc) && (mp - 18) >= 0){
				
				dano = c.sagSpi(c.getPf(), c.getPm());
				
				play.c.setMp(mp - 18);
				
				System.out.println("\n" + play.getNome() + ": Flechas m�gicas que podem perfurar qualquer coisa! SAGITTIS SPIRITUALIS!");
				
			}
			else if("3".equals(opc) && (mp - 5) >= 0){
				
				dano = c.proin(c.getPf(), c.getPm());
				
				play.c.setMp(mp - 5);
				
				System.out.println("\n" + play.getNome() + ": Uma Chuva m�gica que utiliza meu poder m�gico!! PROIN");
				
				if(dano <= 50){
					System.err.println("Voc� � um arqueiro, fazer chover realmente n�o � o seu forte...");
				}else{
					System.err.println("O Seu Chuvisco pode realmente virar uma tempestade!!");
				}
				
			}
			else if("4".equals(opc) && (mp - 15) >= 0){
				
				dano = c.dupSag(c.getPf(), c.getPm());
				
				play.c.setMp(mp-15);
				
				System.out.println("\n" + play.getNome() + ": Nada pode Parar minhas Flechas Duplas!! DUPLEX SAGITTIS");
				
			}
			else{
				
				System.err.println("Voc� n�o tem mana Suficiente!");
				
			}
		}
		
		System.err.println("Dano causado: " + df.format(dano));
		System.err.println("Voc� tem: " + play.c.getMp() + " de mana.");
		
		return dano;
		
	}

}
