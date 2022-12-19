package br.ada.redesocial.menu;

import br.ada.redesocial.RedeSocial;
import br.ada.redesocial.exceptions.InvalidMenuOptionException;

import java.util.Scanner;

public abstract class Menu {
    private final String CABECALHO;
    private final OpcoesMenu[] opcoesMenu;
    protected RedeSocial redeSocial;

    public Menu (OpcoesMenu[] opcoesMenu, String CABECALHO) {
        this.opcoesMenu = opcoesMenu;
        this.CABECALHO = CABECALHO;
        redeSocial = RedeSocial.getInstance();
    }

    public void exibir() {
        formatarCabecalho(CABECALHO);
        System.out.println("Digite uma das opções abaixo para começar:");
        exibirOpcoesDeMenu();

        try {
            determinarAcao(selecionarOpcaoDeMenu());
        } catch (NumberFormatException | InvalidMenuOptionException e) {
            System.out.println("Essa opção não existe. Por favor, escolha uma opção válida!");
            exibir();
        }
    }

    protected void formatarCabecalho(String cabecalho) {
        final String simbolo = "-";
        final int qtdeSimbolo = 50;
        int qtdeSimboloNaLinhaDoCabecalho = (qtdeSimbolo - cabecalho.length() - 2)/2;
        boolean isTamanhoCabecalhoImpar = cabecalho.length()%2 != 0;

        System.out.println("\n" + simbolo.repeat(qtdeSimbolo));
        System.out.print(simbolo.repeat((qtdeSimboloNaLinhaDoCabecalho)));
        System.out.print(" " + cabecalho + " ");
        System.out.print(simbolo.repeat(
                isTamanhoCabecalhoImpar ? qtdeSimboloNaLinhaDoCabecalho + 1 : qtdeSimboloNaLinhaDoCabecalho
                )
        );
        System.out.println("\n" + simbolo.repeat(qtdeSimbolo));
    }

    private void exibirOpcoesDeMenu() {
        int numeroOpcao = 1;
        for (OpcoesMenu descricaoOpcao : opcoesMenu) {
            System.out.println(numeroOpcao++ + " - para " + descricaoOpcao.toString() + ";");
        }
    }

    private int selecionarOpcaoDeMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Opção: ");
        return Integer.parseInt(scan.nextLine());
    }

    protected abstract void determinarAcao(int opcaoSelecionada);
}
