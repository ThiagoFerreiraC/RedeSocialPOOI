package br.ada.redesocial.menu;

public class MenuInicial extends Menu {

    public MenuInicial() {
        super(new String[]{"Cadastrar-se", "Entrar", "Fechar"});
    }

    @Override
    public void getCabecalho() {
        System.out.println("\nSeja bem-vindo(a) ao Exemplário!");
    }

    @Override
    public void determinarAcao(String opcao) {
        switch (opcao) {
            case "1":
                System.out.println("\n------------TELA DE CADASTRO---------");
                adicionarUsuario();
                break;
            case "2":
                System.out.println("\n------------TELA DE LOGIN---------");
                fazerLogin();
                break;
            case "3":
                System.out.println("Esperamos te ver em breve!");
                break;
            default:
                System.out.println("Opção inválida!");
                executarMenu();
        }
    }
}
