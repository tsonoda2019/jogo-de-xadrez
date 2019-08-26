package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.XadrezException;
import xadrez.XadrezPosicao;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		PartidaXadrez partida = new PartidaXadrez();

		while (true) {
			try {
				UI.limparTela();
				UI.printTabuleiro(partida.peca());
				System.out.println();
				System.out.print("Origem: ");
				XadrezPosicao origem = UI.lerXadrezPosicao(sc);
				System.out.println();
				System.out.print("Destino: ");
				XadrezPosicao destino = UI.lerXadrezPosicao(sc);
	
				PecaXadrez pecaCapturada = partida.moverPeca(origem, destino);
			}
			catch (XadrezException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}

	}

}
