package controller;

import java.util.Random;

public class ThreadCompetidor extends Thread {

	static int qtdVitoriosos;
	private Random a = new Random();
	private int idJogador;

	public ThreadCompetidor(int idJogador) {
		this.idJogador = idJogador;
		this.start();
	}

	public void run() {
		competir();
	}

	public boolean jogarDados() {
		int dadoA = 0, dadoB = 0;
		dadoA = a.nextInt(6) + 1;
		dadoB = a.nextInt(6) + 1;
		if (dadoA + dadoB == 7 || dadoA + dadoB == 11) {
			return true;
		} else {
			return false;
		}
	}

	public void competir() {
		int pontuacao = 0;
		do {
			try {
				sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (jogarDados() == true) {
				pontuacao++;
			}
		} while (pontuacao < 5);
		qtdVitoriosos++;

		switch (qtdVitoriosos) {
		case 1:
			System.out.println("Jogador n°" + idJogador + " ganhou R$ 5000,00" );
			break;
		case 2:
			System.out.println("Jogador n°" + idJogador + " ganhou R$ 4000,00" );
			break;
		case 3:
			System.out.println("Jogador n°" + idJogador + " ganhou R$ 3000,00" );
			break;
		default:
			System.out.println("Jogador n°" + idJogador + " não ganhou nada! " );
		}
	}
}
