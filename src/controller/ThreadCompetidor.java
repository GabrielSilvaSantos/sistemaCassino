/*
 @author gabriels
 @date 14/04/2020
*/
package controller;

import java.util.Random;

public class ThreadCompetidor extends Thread {

	// Variáveis para identificação e controle dos jogadores
	static int qtdVitoriosos;
	private int idJogador;
	private Random a = new Random();

	// Construtor da classe junto a inicialização da thread
	public ThreadCompetidor(int idJogador) {

		this.idJogador = idJogador;
		this.start();
	}

	// Chamada do método ao iniciar a thread
	public void run() {

		competir();
	}

	// Método para lançamento dos dados
	public boolean jogarDados() {

		int dadoA = 0;
		int dadoB = 0;

		// Definição de valores aleatórios nos dados
		dadoA = a.nextInt(6) + 1;
		dadoB = a.nextInt(6) + 1;

		// Validação da regra de pontuação
		if (dadoA + dadoB == 7 || dadoA + dadoB == 11) {
			return true;
		} else {
			return false;
		}
	}

	// Método para controle da pontuação e dos jogadores
	public void competir() {

		int pontuacao = 0;
		do {
			try {
				sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Soma pontuação
			if (jogarDados() == true) {
				pontuacao++;
			}
		} while (pontuacao < 5);

		//
		qtdVitoriosos++;

		// Controla e exibe os ganhadores e perdedores
		switch (qtdVitoriosos) {
		case 1:
			System.out.println("JOGADOR N°" + idJogador + " ganhou R$ 5000,00");
			break;
		case 2:
			System.out.println("JOGADOR N°" + idJogador + " ganhou R$ 4000,00");
			break;
		case 3:
			System.out.println("JOGADOR N°" + idJogador + " ganhou R$ 3000,00");
			break;
		default:
			System.out.println("JOGADOR N°" + idJogador + " não ganhou nada! ");

		}
	}
}
