package br.ada.redesocial.menu;

public class MenuUsuario extends Menu{

    public MenuUsuario() {
        super(new String[]{"Postar", "Timeline", "Sair"});
    }
    @Override
    public void getCabecalho() {
        System.out.println("\n----MENU DO USUÁRIO ------");
    }

    @Override
    public void determinarAcao(String opcao) {
        switch (opcao) {
            case "1":
                postar();
                executarMenu();
                break;
            case "2":
                exibirTimeline();
                executarMenu();
                break;
            case "3":
                iniciarExecucaoPrograma();
                break;
            default:
                System.out.println("Opção inválida. Por favor, digite novamente!");
                executarMenu();
        }
    }
}
