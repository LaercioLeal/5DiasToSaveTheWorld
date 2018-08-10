package br.com.SaveTheWorld.Principal;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

import br.com.SaveTheWorld.PlayerClasse.*;

public class Historia{
	
	static Scanner tcld = new Scanner(System.in);
	
	public Double IniAtq(Inimigo ini){
		
		Random r = new Random();
		Integer opc = r.nextInt(4)+1;
		Double dano = null;
		
		if(opc.equals(1)){
			
			System.out.println("SINTA O PODER DO MEU ATAQUE!");
			dano = ini.AtqBas();
			
			System.err.println("Você sofreu " + dano + " de dano");
			
		}
		else if(opc.equals(2)){
			
			dano = ini.Interitum();
			
		}
		else if(opc.equals(3)){
			
			dano = ini.Mundi();
			
		}
		else if(opc.equals(4)){
			
			dano = ini.Vene();
			
		}
		
		return dano;
		
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
			
			dano = Historia.ExibeAtq(play, opc);
			
			dano = ini.getHp() - dano;
			
			ini.setHp(dano);
			
			if(play.c.getHp() <= 0){
				System.err.println("Oh, você Morreu!!");
				break;
			}
			else if(ini.getHp() <= 0){
				System.err.println("Oh, Você matou seu oponente!");
			}
			else{
				System.err.println("Você tem: " + df.format(play.c.getHp()) + " de HP.");
				System.err.println("Seu inimigo tem: " + df.format(ini.getHp()) + " de Hp.");	
			}
			
		}while((ini.getHp()) > 0);
		
		play.c.setHp(Hp);
		play.c.setMp(Mp);
		
		return play;
		
	}
	
	public static Double ExibeAtq(Player play, String opc){
		
		DecimalFormat df = new DecimalFormat("###,##0.00");
		
		Double dano = 0.0;
		
		Integer mp = play.c.getMp();
		
		if(play.c instanceof Cavaleiro){
			
			Cavaleiro c = (Cavaleiro) play.getC();
			
			System.out.print("1-Ataque Básico\t2-Magia Gladium\t3-Tantum Lumen\t4-Secans");
			
			opc = tcld.nextLine();
			
			if("1".equals(opc)){
				
				dano = play.c.atqBas(play.c.getPf(), play.c.getPm());
				
			}
			else if("2".equals(opc) && (mp - 25) >= 0){
				
				dano = c.espMag(c.getPf(), c.getPm());
				
				play.c.setMp(mp - 25);
				
				System.out.println("\nSinta a magia da minha Espada! MAGIA GLADIUM!");
				
			}
			else if("3".equals(opc) && (mp - 10) >= 0){
				
				dano = c.lux(c.getPm());
				
				play.c.setMp(mp - 10);
				
				System.out.println("\nMeu Poder Mágico e toda sua beleza!! TANTUM LUMEN!!\n");
				
				if(dano <= 50){
					System.err.println("Esta é uma magia para iluminação que causa pouco dano na vista das pessoas");
				}else{
					System.err.println("Você é um cavaleiro com um poder mágico muito alto!!");
				}
				
			}
			else if("4".equals(opc)){
				dano = c.secans(c.getPf());
				
				System.out.println("\nO Poder do meu Cajado! POTENTIA!");
				
			}
			else{
				
				System.err.println("Você não tem Suficiente!");
				
			}
			
		}
		else if(play.c instanceof Mago){
			
			Mago c = (Mago) play.getC();
			
			System.out.print("1-Ataque Básico\t2-Potentia\t3-Ferrum\t4-Interitum");
			
			opc = tcld.nextLine();
			
			if("1".equals(opc)){
				
				dano = play.c.atqBas(play.c.getPf(), play.c.getPm());
				
			}
			else if("2".equals(opc) && (mp-20) >= 0 ){
				
				dano = c.pot(c.getPf(), c.getPm());
				
				play.c.setMp(mp-20);
				
				System.out.println("\nO Poder do meu Cajado! POTENTIA!");
			
			}
			else if("3".equals(opc)){
				
				dano = c.ferrum(c.getPf());
				
				System.out.println("\nTodo o Poder do meu Corpo! FERRUM!");
				
				if(dano <= 50){
					System.err.println("Você é um mago, não devia sair por ai dando socos");
				}else{
					System.err.println("Você é realmente um mago com um soco poderoso!!");
				}
				
			}
			else if("4".equals(opc) && (mp-30) >= 0){
				
				dano = c.inter(c.getPm());
				
				play.c.setMp(mp - 30);
				
				System.out.println("\nSinta sua destruição!! INTERITUM!");
				
			}
			else{
				
				System.err.println("Você não tem Suficiente!");
				
			}
			
		}
		else if(play.c instanceof Lutador){
			
			Lutador c = (Lutador) play.getC();
			
			System.out.print("1-Ataque Básico\t2-Pugnis et Magia\t3-Ictu\t4-Pugnis Simplex");
			
			opc = tcld.nextLine();
			
			if("1".equals(opc)){
				
				dano = play.c.atqBas(play.c.getPf(), play.c.getPm());
				
			}
			else if("2".equals(opc) && (mp - 25) >= 0){
				
				dano = c.pugMag(c.getPf(), c.getPm());
				
				play.c.setMp(mp - 25);
				
				System.out.println("\nMeu poder físico e mágico juntos! PUGNIS ET MAGIA!!");
				
			}
			else if("3".equals(opc) && (mp - 10) >= 0){
				
				dano = c.ictu(c.getPm());
				
				play.c.setMp(mp - 10);
				
				System.out.println("\nCom um simples sopro mágico eu posso acabar com você! ICTU!");
				
				if(dano <= 50){
					System.err.println("Você é um lutador, não deveria sair soprando os outros por ai...");
				}else{
					System.err.println("NOSSA! você tem um sopro realmente Poderoso!!");
				}
				
			}
			else if("4".equals(opc)){
				
				dano = c.pub(c.getPf());
				
				System.out.println("\nSinta o poder dos meus socos! PUGNIS SIMPLEX");
				
			}
			else{
				
				System.err.println("Você não tem Suficiente!");
				
			}
		}
		else if(play.c instanceof Arqueiro){
			
			Arqueiro c = (Arqueiro) play.getC();
			
			System.out.print("1-Ataque Básico\t2-Sagittis Spiritualis\t3-Proin\t4-Duplex Sagittis");
			
			opc = tcld.nextLine();
			
			if("1".equals(opc)){
				
				dano = play.c.atqBas(play.c.getPf(), play.c.getPm());
				
			}
			else if("2".equals(opc) && (mp - 18) >= 0){
				
				dano = c.sagSpi(c.getPf(), c.getPm());
				
				play.c.setMp(mp - 18);
				
				System.out.println("\nFlechas mágicas que podem perfurar qualquer coisa! SAGITTIS SPIRITUALIS!");
				
			}
			else if("3".equals(opc) && (mp - 5) >= 0){
				
				dano = c.proin(c.getPf(), c.getPm());
				
				play.c.setMp(mp - 5);
				
				System.out.println("\nUma Chuva mágica que utiliza meu poder mágico!! PROIN");
				
				if(dano <= 50){
					System.err.println("Você é um arqueiro, fazer chover realmente não é o seu forte...");
				}else{
					System.err.println("O Seu Chuvisco pode realmente virar uma tempestade!!");
				}
				
			}
			else if("4".equals(opc) && (mp - 15) >= 0){
				
				dano = c.dupSag(c.getPf(), c.getPm());
				
				play.c.setMp(mp-15);
				
				System.out.println("\nNada pode Parar minhas Flechas Duplas!! DUPLEX SAGITTIS");
				
			}
			else{
				
				System.err.println("Você não tem Suficiente!");
				
			}
		}
		
		System.err.println("Dano causado: " + df.format(dano));
		System.err.println("Você tem: " + play.c.getMp());
		
		return dano;
		
	}
}
