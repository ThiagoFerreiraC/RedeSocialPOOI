package br.ada.redesocial.menu;

import br.ada.redesocial.RedeSocial;

public abstract class Menu extends RedeSocial {
    private String[] opcoesDeCadaMenu;
    public Menu (String[] opcoesDeCadaMenu) {
        this.opcoesDeCadaMenu = opcoesDeCadaMenu;
    }
    public void executarMenu() {
        getCabecalho();
        System.out.println("Digite uma das opções abaixo para começar:");
        imprimirOpcoes();
        System.out.print("Opção: ");
        String opcaoSelecionada = scan.nextLine();
        determinarAcao(opcaoSelecionada);
    }

    public abstract void getCabecalho();
    private void imprimirOpcoes() {
        int numeroOpcao = 1;
        for (String descricaoOpcao : opcoesDeCadaMenu) {
            System.out.println(numeroOpcao++ + " - para " + descricaoOpcao + ";");
        }
    }
    public abstract void determinarAcao(String opcao);

}
