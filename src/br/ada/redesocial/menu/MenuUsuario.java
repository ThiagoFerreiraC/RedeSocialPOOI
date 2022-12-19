package br.ada.redesocial.menu;

import br.ada.redesocial.exceptions.FieldIsBlankException;
import br.ada.redesocial.exceptions.InvalidMenuOptionException;
import br.ada.redesocial.perfil.Perfil;

public class MenuUsuario extends Menu{
    private Perfil usuario;
    public MenuUsuario(Perfil usuario) {
        super(
                new OpcoesMenu[]{
                        OpcoesMenu.POSTAR,
                        OpcoesMenu.TIMELINE,
                        OpcoesMenu.SAIR},
                "Menu do Usuario");
        this.usuario = usuario;
    }

    public void determinarAcao(int opcaoSelecionada) throws InvalidMenuOptionException {
        switch (opcaoSelecionada) {
            case 1:
                try {
                    formatarCabecalho("Tela de Postagem");
                    usuario.postar();
                } catch (FieldIsBlankException e) {
                    System.out.println(e.getMessage());
                }
                redeSocial.iniciarMenuUsuario();
                break;
            case 2:
                usuario.visualizarTimeline();
                redeSocial.iniciarMenuUsuario();
                break;
            case 3:
                redeSocial.deslogarUsuario();
                redeSocial.iniciarExecucaoPrograma();
                break;
            default:
                throw new InvalidMenuOptionException();
        }
    }

}
