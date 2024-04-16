package aplication;

import java.text.ParseException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		int opcao = 0;
		
		while(opcao != 7) {
			switch (opcao) {
			case 0:
				System.out.print(Menu.menuInicial());
				opcao = sc.nextInt();
				break;
			case 1:
				Menu.imprimirPedidos();
				Menu.digiteParaContinuar();
				opcao = 0;
				break;
			case 2:
				Menu.novoPedido();
				Menu.digiteParaContinuar();
				opcao = 0;
				break;
			case 3:
				Menu.editarPedido();
				Menu.digiteParaContinuar();
				opcao = 0;
				break;
			case 4:
				Menu.excluirPedido();
				Menu.digiteParaContinuar();
				opcao = 0;
				break;
			case 7:
				System.out.println("Saindo do sistema...");
			default:
				System.out.println("Valor inválido! Digite outro valor.");
			}
		}		
		
		sc.close();
	}

}
