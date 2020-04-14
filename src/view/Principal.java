package view;

import controller.ThreadCompetidor;

public class Principal {
	public static void main(String[] args) {
		
		for (int jogador = 1; jogador < 11; jogador++) {
			Thread jogo = new ThreadCompetidor(jogador);
		}
	}
}
