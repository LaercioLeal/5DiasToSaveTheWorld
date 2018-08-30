package br.com.SaveTheWorld.Principal;

import java.text.DecimalFormat;
import java.util.Scanner;

import br.com.SaveTheWorld.PlayerClasse.Arqueiro;
import br.com.SaveTheWorld.PlayerClasse.Cavaleiro;
import br.com.SaveTheWorld.PlayerClasse.Inimigo;
import br.com.SaveTheWorld.PlayerClasse.Lutador;
import br.com.SaveTheWorld.PlayerClasse.Mago;

public class Jogo {

	static Scanner tcld = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Declaração das Variáveis
		Player play;
		String opc, nome;
		Integer ret, index;
		DecimalFormat df = new DecimalFormat("###,##0.00");
		
		System.out.println("5DiasToSavetheWorld!!");
		System.out.println("\nSeja Bem-Vindo Jogador!");
		System.out.println("O que deseja fazer?");
		System.out.println("\t1-Começar\n\t2-Informações\n\t3-Sair");
		
		opc = tcld.nextLine();
		
		if(opc.equals("1") || opc.equalsIgnoreCase("Começar")){
			
			//Inicio da Criação do personagem
			
			System.out.println("Digite o Nome de seu Personagem: ");
			nome = tcld.nextLine();

			play = new Player(nome);
			
			System.out.println("Escolha a Classe desejada:");
			System.out.println("\n\t1-Cavaleiro\n\t2-Mago\n\t3-Lutador\n\t4-Arqueiro");
		
			opc = tcld.nextLine();
			
			play = Jogo.cria(play, opc);
			
			//Variáveis Auxiliares para recuperar atributos
			play.c.setHpMax(play.c.getHp());
			play.c.setMpMax(play.c.getMp());
			play.c.setEnergiaMax(play.c.getEnergia());
			
			//Exibindo dados do jogador
			System.out.println("Nome: " + play.getNome() + "\tLevel: " + play.getLvl() + "\tExp: " + play.getExp() + "/" + play.nextLvl() + "\tGold: " + play.getGold() + "\nEquipamentos: " + play.getEquipNome());
			System.out.println("Hp: " + df.format(play.c.getHp())+ "/" + df.format(play.c.getHpMax()) + "\tMp: " + play.c.getMp() + "/" + play.c.getMpMax() 
			   + "\tPf: " + play.c.getPf() + "\tPm: " + play.c.getPm() + "\tEnergia: " + play.c.getEnergia() + "/" + play.c.getEnergiaMax());
			
			//Cria Loja
			Loja l = Jogo.criaLoja();
			
			do{
				
				//Inicio do Jogo
				
				System.out.println("\nOlá. O que deseja fazer agora?");
				System.out.println("\t1-Enfrentar meus Inimigos(LUTAR)!\n\t2-Trabalhar");
				System.out.println("\t3-Treinar\n\t4-Loja\n\t5-Descansar (50 G)\n\t6-Mochila\n\t7-Sair");
				
				opc = tcld.nextLine();
				
				if(opc.equals("1") || opc.equalsIgnoreCase("Lutar")){
					
					play = Jogo.historia(play);
					
				}
				else if(opc.equals("2") || opc.equalsIgnoreCase("Trabalhar")){
					
						play = Jogo.trabalho(play);
				
				}
				else if(opc.equals("3") || opc.equalsIgnoreCase("Treinar")){
					play = Jogo.treinar(play, opc);
				}
				else if(opc.equals("4") || opc.equalsIgnoreCase("Loja")){
					
					Jogo.loja(play, l);
					
				}
				else if (opc.equals("5") || opc.equalsIgnoreCase("Descansar")){
					
					if((play.getGold() - 50.0) >= 0){
							
						play.setGold(play.getGold() - 50.0);
						play.c.setHp(play.c.getHpMax());
						play.c.setMp(play.c.getMpMax());
						play.c.setEnergia(play.c.getEnergiaMax());
						
						System.out.println("Você se recuperou bem!!");
					}
					else{
						System.out.println("Você não tem Gold suficiente");
					}
				}
				else if (opc.equals("6")){
					if(play.getBag().isEmpty()){
						System.out.println("Você não tem itens");
					}
					else{
						System.out.println("Você tem os seguintes itens: ");
						for(Item i : play.getBag()){							
							System.out.println(i);
						}	
						System.out.println("O que deseja fazer? \n1-Equipar\n2-Desequipar\n0-Voltar");
						opc = tcld.nextLine();
						if(opc.equals("1") || opc.equalsIgnoreCase("Equipar")){
							
							System.out.println("Selecione o item que deseja equipar:\n");
							opc = tcld.nextLine();
							index = play.getIndex(Integer.parseInt(opc));
							

							if(index == null){
								System.out.println("Você não possui este item ou o item não existe");
							}
							else if(play.getBag().contains(play.getBag().get(index))){
								play.setEquip(play.getBag().get(index));
								System.out.println("Item Equipado com Sucesso!");
							}
						}
						else if(opc.equals("2") || opc.equalsIgnoreCase("Desequipar")){
							System.out.println("Selecione o item que deseja desequipar:\n");
							opc = tcld.nextLine();
							index = play.getIndex(Integer.parseInt(opc));
							
							if(index == null){
								System.out.println("Você não possui este item ou o item não existe");
							}
							else if(play.getBag().contains(play.getBag().get(index))){
								play.removeEquip();
								System.out.println("Item Equipado com Sucesso!");
							}
							
						}
						else if(opc.equals("0") || opc.equalsIgnoreCase("Voltar"));
					}
				}
				ret = play.verificaExp();
				
				if(play.c.getHp() <= 0){
					System.out.println("GAME OVER!");
					break;
				}
				else if(ret == 1){
					System.err.println("Parabéns! Você passou de nivel!\nSeu nível agora é: " + play.getLvl());
					System.out.println("Você precisa de " + df.format(play.nextLvl()) + " de experiência para o próximo nível.");
					
					play.c.setHpMax(play.c.getHp());
					play.c.setMpMax(play.c.getMp());
					play.c.setEnergiaMax(play.c.getEnergia());
					
				}
				
				System.out.println("\nNome: " + play.getNome() + "\tLevel: " + play.getLvl() + "\tExp: " + df.format(play.getExp()) + "/" + play.nextLvl()  + "\tGold: " + df.format(play.getGold()) + "\nEquipamentos: " + play.getEquipNome());
				System.out.println("Hp: " + df.format(play.c.getHp())+ "/" + df.format(play.c.getHpMax()) + "\tMp: " + play.c.getMp() + "/" + play.c.getMpMax() 
								   + "\tPf: " + play.c.getPf() + "\tPm: " + play.c.getPm() + "\tEnergia: " + play.c.getEnergia() + "/" + play.c.getEnergiaMax());
				
			}while(!opc.equals("7"));
			
		}
		
		tcld.close();
		
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
	
//MÉTODO PARA LUTAS
	public static Player historia(Player play){
		
		String opc;
		Inimigo ini = new Inimigo();
		DecimalFormat df = new DecimalFormat("###,##0.00");
		Double dano = 0.0;
		Double danop = 0.0;
		Double exp = 0.0;
		
		System.out.println("Selecione Seu Inimigo: ");
		System.out.println("\t1-Arthur O Cavaleiro\t2-Mágico o Mago\t3-Rocky Balboa\t4-Acher o Arqueiro");
		
		opc = tcld.nextLine();
		
		ini = Inimigo.CriaIni(play, opc); //Envia dados para criação do inimigo
		
		System.err.println("Seu inimigo tem: " + df.format(ini.getHp()) + " de Hp.");
		
		do{
			
			System.out.println("Selecione seu Ataque: ");
			
			dano = Historia.ExibeAtq(play, opc); //Dano causado no inimigo
			danop = Historia.IniAtq(ini); //Dano causado no player

			System.err.println("Você sofreu " + df.format(danop) + " de dano.");
			
			dano = ini.getHp() - dano;
			danop = play.c.getHp() - danop;
			
			ini.setHp(dano);
			play.c.setHp(danop);
			
			if(play.c.getHp() <= 0){
				System.err.println("Oh, você Morreu!!");
				System.err.println("Seu inimigo tem: " + df.format(ini.getHp()) + " de Hp.");
				break;
			}
			else if(ini.getHp() <= 0){
				System.err.println("Você tem: " + df.format(play.c.getHp()) + " de HP.");
				System.err.println("Oh, Você matou seu oponente!");
				
				exp = (ini.getPf() + ini.getPm())*0.3;
				
				System.err.println("Você conseguiu: " + df.format(exp) + " de exp.");
				
				exp = play.getExp() + exp;
				play.setExp(exp);
				
			}
			else{
				System.err.println("Você tem: " + df.format(play.c.getHp()) + " de HP.");
				System.err.println("Seu inimigo tem: " + df.format(ini.getHp()) + " de Hp.");	
			}
			
		}while((ini.getHp()) > 0);
		
		return play;
	}
	
//MÉTODO DE TRABALHO
	public static Player trabalho(Player play){
		
		String cat;
		Double remun = 0.0;
		DecimalFormat df = new DecimalFormat("###,##0.00");
		Integer En = 0;
		
		System.out.println("Tenha em mente que você gastará energia ao trabalhar");
		System.out.println("Como deseja trabalhar hoje?");
		System.out.println("\t1-Padeiro\n\t2-Professor\n\t3-Vendedor\n\t4-Policial\n\t5-Politico\n\t6-Voltar");
		
		cat = tcld.nextLine();
		if(cat.equals("6")){
			System.out.println("Até mais!!");
		}else{
			
			if("Padeiro".equalsIgnoreCase(cat) || "1".equals(cat)){
				
				remun = Trabalho.calculoRemuneracao(play.getLvl(), 0.75*play.getExp());
				En = (15*play.c.getEnergia())/100;
				En = Trabalho.descontaEnergia(play.getLvl(), En);
				
				System.out.println("Parabéns por ser um Padeiro tão esforçado!\n");
				
			}
			else if("Professor".equalsIgnoreCase(cat) || "2".equals(cat)){
				
				remun = Trabalho.calculoRemuneracao(play.getLvl(), 0.15*play.getExp());
				En = (50*play.c.getEnergia())/100;
				En = Trabalho.descontaEnergia(play.getLvl(), En);
				
				if(remun <= 200){
					System.out.println("É professor não uma profissão muito bem reconhecida...\n");
				}
				else{
					System.out.println("Uau você é um professor muito bem recompensado!!\n");
				}
				
			}
			else if("Vendedor".equalsIgnoreCase(cat) || "3".equals(cat)){
				
				remun = Trabalho.calculoRemuneracao(play.getLvl(), 0.90*play.getExp());
				En = (25*play.c.getEnergia())/100;
				En = Trabalho.descontaEnergia(play.getLvl(), En);
				
				System.out.println("Você é um vendedor com uma comissão bem vantajosa...\n");
				
			}
			else if("Policial".equalsIgnoreCase(cat) || "4".equals(cat)){
				
				remun = Trabalho.calculoRemuneracao(play.getLvl(), 1.05*play.getExp());
				En = (18*play.c.getEnergia())/100;
				En = Trabalho.descontaEnergia(play.getLvl(), En);
				
				System.out.println("Cuidado no caminho como Policial, nunca se pode imaginar quando você pode levar um tiro!\n");
				
			}
			else if("Politico".equalsIgnoreCase(cat) || "5".equals(cat)){
				
				remun = Trabalho.calculoRemuneracao(play.getLvl(), 2.5*play.getExp());
				En = (3*play.c.getEnergia())/100;
				En = Trabalho.descontaEnergia(play.getLvl(), En);
				
				System.out.println("Você acabou se metendo em um esquema de Corrupção... Parabéns!!\nVocê é um excelente Político.\n");
				
			}
			
			if((play.c.getEnergia()-En) < 0){
				System.out.println("Você não tem Energia suficiente");
			}
			else{
				System.err.println("Você conseguiu: " + df.format(remun) + " de gold!!");
				System.err.println("Você gastou: " + En + " de energia!!");
				remun = remun + play.getGold();
				play.setGold(remun);
				play.c.setEnergia(play.c.getEnergia() - En);
				System.err.println("Você agora tem: " + df.format(play.getGold()) + " de gold!");
				System.err.println("Você agora tem: " + play.c.getEnergia() + " de energia!");
			}
		}
				
		return play;
		
	}

//MÉTODO DE TREINAMENTO
	public static Player treinar(Player play, String opc){
		
		int aux1, aux2; //aux1 para descontar gold ## aux2 para descontar energia
		Integer en, mpMax, enMax;
		Double g, aux, hpMax; //aux para descontar hp
		DecimalFormat df = new DecimalFormat("###,##0.00");
		
		System.out.println("Treinar:\n\t1-HP(20 EN/20G)\n\t2-MP(20 EN/20G)\n\t3-Poder Físico(30 EN/35G)");
		System.out.println("\t4-Poder Mágico(30 EN/35G)\n\t5-Energia(50 HP/40G)\n\t6-Voltar");
		opc = tcld.nextLine();
		
		if(opc.equals("1") || opc.equalsIgnoreCase("HP")){
			//PENSAR EM COMO RESOLVER O PROBLEMA DA ENERGIA MÁXIMA
			
			g = Treino.descontaGold(20.0, play.getGold());
			en = Treino.descontaEn(20, play.c.getEnergia());
			aux1 = g.compareTo(0.0);
			aux2 = en.compareTo(0);
			
			if(aux1 >= 0 && aux2 >= 0){ // >= pois compareTo retorna 1 para maior e 0 para menor
				
				hpMax = Treino.treinoHP(play, play.c.getHpMax());
				play.c.setHpMax(hpMax);
				System.out.println("Você agora tem: " + df.format(hpMax) + " de HP total!");
				play.setGold(g);
				play.c.setEnergia(en);
				
			}
			else if(aux1 < 0 || aux2 < 0){
				System.out.println("Você não tem recursos Suficientes!");
			}
			
		}
		else if(opc.equals("2") || opc.equalsIgnoreCase("MP")){
			
			g = Treino.descontaGold(20.0, play.getGold());
			en = Treino.descontaEn(20, play.c.getEnergia());
			aux1 = g.compareTo(0.0);
			aux2 = en.compareTo(0);
			
			if(aux1 >= 0 && aux2 >= 0){
				
				mpMax = Treino.treinoMP(play, play.c.getMpMax());
				play.c.setMpMax(mpMax);
				System.out.println("Você agora tem: " + mpMax + " de MP total!");
				play.setGold(g);
				play.c.setEnergia(en);
			}
			else if(aux1 < 0 || aux2 < 0){
				System.out.println("Você não tem recursos Suficientes!");
			}
		}
		else if(opc.equals("3") || opc.equalsIgnoreCase("Poder Fisico")){
			g = Treino.descontaGold(35.0, play.getGold());
			en = Treino.descontaEn(30, play.c.getEnergia());
			aux1 = g.compareTo(0.0);
			aux2 = en.compareTo(0);
			
			if(aux1 >= 0 && aux2 >= 0){
				
				play.c.setPf(Treino.treinoAtri(opc, play));
				System.out.println("Você agora tem: " + play.c.getPf() + " de Poder Físico!");
				play.setGold(g);
				play.c.setEnergia(en);
			}
			else if(aux1 < 0 || aux2 < 0){
				System.out.println("Você não tem recursos Suficientes!");
			}
		}
		else if(opc.equals("4") || opc.equalsIgnoreCase("Poder Magico")){
			g = Treino.descontaGold(35.0, play.getGold());
			en = Treino.descontaEn(30, play.c.getEnergia());
			aux1 = g.compareTo(0.0);
			aux2 = en.compareTo(0);
			
			if(aux1 >= 0 && aux2 >= 0){
				
				play.c.setPm(Treino.treinoAtri(opc, play));
				System.out.println("Você agora tem: " + play.c.getPm() + " de Poder Mágico");
				play.setGold(g);
				play.c.setEnergia(en);
			}
			else if(aux1 < 0 || aux2 < 0){
				System.out.println("Você não tem recursos Suficientes!");
			}
		}
		else if(opc.equals("5") || opc.equalsIgnoreCase("Energia")){
			g = Treino.descontaGold(40.0, play.getGold());
			aux1 = g.compareTo(0.0);
			aux = play.c.getHp() - 50.0;
			
			if(aux1 >= 0 && aux >= 0){
				
				enMax = Treino.treinoEn(play, play.c.getEnergiaMax());
				play.c.setEnergiaMax(enMax);
				System.out.println("Você agora tem: " + enMax + " de Energia Total");
				play.setGold(g);
				play.c.setHp(play.c.getHp() - 50);
			}
			else if(aux1 < 0 || aux < 0){
				System.out.println("Você não tem recursos Suficientes!");
			}
		}
		
		return play;
		
	}

//Métodos para a Loja
	public static Loja criaLoja(){
		
		//Criação dos itens da loja	
		Item espMag = new Item(1, "Espada Mágica", "Fisico", 35, "Arma", 300.00);
		Item armPod = new Item(2, "Armadura do Poder", "HP/Fisico", 125, "Vestimenta", 1500.00);
		Item escSim = new Item(3, "Escudo Simples", "HP", 30, "Escudo", 275.00);
		Item cajAg = new Item(4, "Cajado da Água", "Magico", 40, "Arma", 300.00);
		Item mantProt = new Item(5, "Manta Protetora", "HP/Magico", 135, "Vestimenta", 1650.00);
		Item cart = new Item(6, "Cartola", "MP", 40, "Vestimenta", 350.00);
		Item luvTe = new Item(7, "Luvas da Terra", "Fisico", 25, "Arma", 275.00);
		Item cal = new Item(8, "Calção", "HP/MP", 50, "Vestimenta", 265.00);
		Item brac = new Item(9, "Bracelete", "HP/Fisico", 115, "Vestimenta", 1470.00);
		Item arcVent = new Item(10, "Arco do ar", "Fisico/Magico", 30, "Arma", 325.00);
		Item botVel = new Item(11, "Botinha da Velocidade", "HP/Fisico", 40, "Vestimenta", 320.00);
		Item flePer = new Item(12, "Flecha Perfuradora", "Fisico/Magico", 125, "Arma", 1750.00);
		
		//Criação da Loja
		
		Loja l = new Loja();
		l.addItem(espMag);
		l.addItem(armPod);
		l.addItem(escSim);
		l.addItem(cajAg);
		l.addItem(mantProt);
		l.addItem(cart);
		l.addItem(luvTe);
		l.addItem(cal);
		l.addItem(brac);
		l.addItem(arcVent);
		l.addItem(botVel);
		l.addItem(flePer);
		
		return l;
	}

	public static void loja(Player p, Loja l){
		
		String opc;
		Integer aux, index;
		Double pagamento;
		Item it;
		
		do{
			System.out.println("O que deseja fazer?\n1-Comprar\n2-Vender\n3-Voltar");
			opc = tcld.nextLine();
			if(opc.equals("1") || opc.equalsIgnoreCase("Comprar")){
				for(Item i : l.getItens()){
					System.out.println(i);
				}
				
				System.out.println("\n0-Voltar\n");
				System.out.println("Selecione o item que deseja comprar: \n");
	
				opc = tcld.nextLine();
				index = l.getIndex(Integer.parseInt(opc)); // Chama método para pegar index
				
				if(index == null){
					System.out.println("Esse item ja foi vendido ou não existe");
				}
				else if(Integer.parseInt(opc) > 0){
					it = l.getItens().get(index); // Pega o Objeto que deseja comprar
					pagamento = l.descontaGold(it.getPreco(), p.getGold());
					aux = pagamento.compareTo(0.0);
					
					if(aux >= 0 && l.getItens().contains(it)){ // Verifica se pode ser vendido
						p.setGold(pagamento);
						l.vendeItem(it);
						p.getBag().add(it);
						System.out.println("Item comprado com Sucesso!!");
					}
					else{
						System.out.println("Você não tem dinheiro Suficiente!");
					}
				}
			}
			else if(opc.equals("2") || opc.equalsIgnoreCase("Vender")){
				
				for(Item i : p.getBag()){
					System.out.println(i);
				}
				
				System.out.println("\n0-Voltar\n");
				System.out.println("Selecione o item que deseja vender: \n");
				
				opc = tcld.nextLine();
				index = p.getIndex(Integer.parseInt(opc));
				if(index == null){
					System.out.println("Você não possui este item ou o item não existe");
				}
				else{
					it = p.getBag().get(index);
					 
					if(it.equals(p.getEquip())){
						p.removeEquip();
					}
					if(Integer.parseInt(opc) > 0 && p.getBag().contains(it)){
						pagamento = l.recebeGold(it.getPreco(), p.getGold());
						p.setGold(pagamento);
						p.getBag().remove(it);
						l.itens.remove(it);
						System.out.println("Item vendido com Sucesso");
						
					}
				}
				
			}
		}while(!(opc.equals("3") || opc.equalsIgnoreCase("Voltar")));
		
	}
}