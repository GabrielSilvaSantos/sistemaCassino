/*
 @author gabriels
 @date 14/04/2020
*/
package view;

import controller.ThreadCompetidor;

public class Principal {
	public static void main(String[] args) {

		// Chamada da thread contendo 10 jogadores
		for (int jogador = 1; jogador <11; jogador++) {
			Thread jogo = new ThreadCompetidor(jogador);
		}
	}
}
