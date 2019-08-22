package xadrez;

import tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {

	private Tabuleiro tabuleiro;

	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		configuracaoInicial();
	}

	public PecaXadrez[][] peca() {
		PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i = 0; i < tabuleiro.getLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColunas(); j++) {
				mat[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
			}
		}
		return mat;
	}

	private void inserirNovaPeca(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.posicionarPeca(peca, new XadrezPosicao(coluna, linha).toPosicao());
	}

	private void configuracaoInicial() {
		inserirNovaPeca('c', 1, new Torre(tabuleiro, Cor.BRANCA));
		inserirNovaPeca('d', 2, new Torre(tabuleiro, Cor.BRANCA));
		inserirNovaPeca('e', 2, new Torre(tabuleiro, Cor.BRANCA));
		inserirNovaPeca('e', 1, new Torre(tabuleiro, Cor.BRANCA));
		inserirNovaPeca('d', 1, new Torre(tabuleiro, Cor.BRANCA));

		inserirNovaPeca('c', 7, new Torre(tabuleiro, Cor.PRETA));
		inserirNovaPeca('c', 8, new Torre(tabuleiro, Cor.PRETA));
		inserirNovaPeca('d', 7, new Torre(tabuleiro, Cor.PRETA));
		inserirNovaPeca('e', 7, new Torre(tabuleiro, Cor.PRETA));
		inserirNovaPeca('e', 8, new Torre(tabuleiro, Cor.PRETA));
		inserirNovaPeca('d', 8, new Rei(tabuleiro, Cor.PRETA));
	}
}
