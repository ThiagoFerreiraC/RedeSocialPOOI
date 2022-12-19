package br.ada.redesocial.menu;

import br.ada.redesocial.exceptions.*;
public class MenuInicial extends Menu {

    public MenuInicial() {
        super(
                new OpcoesMenu[]{
                        OpcoesMenu.CADASTRAR,
                        OpcoesMenu.ENTRAR,
                        OpcoesMenu.FECHAR
                },
                "Seja bem-vindo(a) ao Exemplário!");
    }

    public void determinarAcao(int opcaoSelecionada) throws InvalidMenuOptionException {
        switch (opcaoSelecionada) {
            case 1:
                try {
                    formatarCabecalho("Tela de Cadastro");
                    redeSocial.cadastrarUsuario();
                } catch (FieldIsBlankException e) {
                    System.out.println(e.getMessage());
                } catch (LoginInUseException e) {
                    System.out.println(e.getMessage());
                }
                redeSocial.iniciarExecucaoPrograma();
                break;
            case 2:
                try {
                    formatarCabecalho("Tela de Login");
                    redeSocial.logarUsuario();
                    redeSocial.iniciarMenuUsuario();
                } catch (UserNotFoundException e) {
                    System.out.println(e.getMessage());
                    redeSocial.iniciarExecucaoPrograma();
                } catch (InvalidPasswordException e) {
                    System.out.println(e.getMessage());
                    redeSocial.iniciarExecucaoPrograma();
                }
                break;
            case 3:
                System.out.println("Esperamos te ver em breve!");
                break;
            default:
                throw new InvalidMenuOptionException();
        }
    }
}
