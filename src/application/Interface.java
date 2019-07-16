package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.Cor;
import xadrez.PecaXadrez;
import xadrez.XadrezPosicao;

public class Interface {
	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	//cores das letras
		public static final String ANSI_RESET = "\u001B[0m";
		public static final String ANSI_BLACK = "\u001B[30m";
		public static final String ANSI_RED = "\u001B[31m";
		public static final String ANSI_GREEN = "\u001B[32m";
		public static final String ANSI_YELLOW = "\u001B[33m";
		public static final String ANSI_BLUE = "\u001B[34m";
		public static final String ANSI_PURPLE = "\u001B[35m";
		public static final String ANSI_CYAN = "\u001B[36m";
		public static final String ANSI_WHITE = "\u001B[37m";
// cores do fundo
		public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
		public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
		public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
		public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
		public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
		public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
		public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
		public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
		// limpa tela 
		public static void limpaTela() {
			System.out.println("\033[H\033[2J");
			System.out.flush();
		}
		
		
		//metodo para ler posicao 
		public static XadrezPosicao lerXadrezPosicao (Scanner scan) {
			try {
			String s = scan.nextLine();
			char coluna = s.charAt(0);
			int linha = Integer.parseInt(s.substring(1)); //capura numero apartir da posicao 1 da string
			return new XadrezPosicao(coluna,linha);
			}
			catch (RuntimeException e) {
				throw new InputMismatchException("Erro lendo posicao de Xadrez. Valores validos sao de a1 ate h8");
			}
			
		}
		
		// metodo static pois eh da classe apenas
	public static void ImpressaoTabuleiro(PecaXadrez[][] pecas) { // recebe uma matriz de pecasXadrez
		for (int i = 0; i < pecas.length; i++) {
			System.out.print(8 - i + " ");
			for (int j = 0; j < pecas.length; j++) {
				imprimePeca(pecas[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");

	}

	// metodo auxiliar imprime uma peca
	// recebe uma peca
	private static void imprimePeca(PecaXadrez peca) {
		if (peca == null) { // se peca estiver vazia
			System.out.print("-");
		} else {// caso exista peca imprime ela ** codigo para imprimir com cor diferente
			if(peca.getCor() == Cor.BRANCA) {
				System.out.print(ANSI_WHITE + peca + ANSI_RESET);
			}else {
				System.out.print(ANSI_YELLOW + peca + ANSI_RESET);
			}
			
		}
		System.out.print(" ");
	}
}
