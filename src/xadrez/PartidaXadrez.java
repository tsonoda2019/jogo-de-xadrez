package xadrez;

import tabuleiro.Peca;
import tabuleiro.Posicao;
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

	public PecaXadrez moverPeca(XadrezPosicao posicaoOrigem, XadrezPosicao posicaoDestino) {
		Posicao origem = posicaoOrigem.toPosicao();
		Posicao destino = posicaoDestino.toPosicao();
		validarPosicaoOrigem(origem);
		ValidarPosicaoDestino(origem, destino);
		Peca pecaCapturada = realizarMover(origem, destino);
		return (PecaXadrez) pecaCapturada;

	}

	private Peca realizarMover(Posicao posicaoOrigem, Posicao posicaoDestino) {
		Peca p = tabuleiro.removePeca(posicaoOrigem);
		Peca pecaCapturada = tabuleiro.removePeca(posicaoDestino);
		tabuleiro.posicionarPeca(p, posicaoDestino);

		return pecaCapturada;
	}

	private void validarPosicaoOrigem(Posicao posicao) {
		if (!tabuleiro.temUmaPecaNaPosicao(posicao)) {
			throw new XadrezException("Nao existe peca na posicao de origem.");
		}

		if (!tabuleiro.peca(posicao).temAlgumMovimentoPossivel()) {
			throw new XadrezException("Nao existe movimento possivel para a peca");
		}
	}

	private void ValidarPosicaoDestino(Posicao origem, Posicao destino) {
		if (!tabuleiro.peca(origem).movimentoPossivel(destino)) {
			throw new XadrezException("A peca escolhida nao pode se mover para a posicao de destino");
		}
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
