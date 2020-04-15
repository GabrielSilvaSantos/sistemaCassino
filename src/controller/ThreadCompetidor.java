/*
 @author gabriels
 @date 14/04/2020
*/
package controller;

import java.util.Random;

public class ThreadCompetidor extends Thread {

	// Vari�veis para identifica��o e controle dos jogadores
	static int qtdVitoriosos;
	private int idJogador;
	private Random a = new Random();

	// Construtor da classe junto a inicializa��o da thread
	public ThreadCompetidor(int idJogador) {

		this.idJogador = idJogador;
		this.start();
	}

	// Chamada do m�todo ao iniciar a thread
	public void run() {

		competir();
	}

	// M�todo para lan�amento dos dados
	public boolean jogarDados() {

		int dadoA = 0;
		int dadoB = 0;

		// Defini��o de valores aleat�rios nos dados
		dadoA = a.nextInt(6) + 1;
		dadoB = a.nextInt(6) + 1;

		// Valida��o da regra de pontua��o
		if (dadoA + dadoB == 7 || dadoA + dadoB == 11) {
			return true;
		} else {
			return false;
		}
	}

	// M�todo para controle da pontua��o e dos jogadores
	public void competir() {

		int pontuacao = 0;
		do {
			try {
				sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Soma pontua��o
			if (jogarDados() == true) {
				pontuacao++;
			}
		} while (pontuacao < 5);

		//
		qtdVitoriosos++;

		// Controla e exibe os ganhadores e perdedores
		switch (qtdVitoriosos) {
		case 1:
			System.out.println("JOGADOR N�" + idJogador + " ganhou R$ 5000,00");
			break;
		case 2:
			System.out.println("JOGADOR N�" + idJogador + " ganhou R$ 4000,00");
			break;
		case 3:
			System.out.println("JOGADOR N�" + idJogador + " ganhou R$ 3000,00");
			break;
		default:
			System.out.println("JOGADOR N�" + idJogador + " n�o ganhou nada! ");

		}
	}
}
