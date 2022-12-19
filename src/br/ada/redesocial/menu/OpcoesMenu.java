package br.ada.redesocial.menu;

public enum OpcoesMenu {
    CADASTRAR("Cadastrar-se"),
    ENTRAR("Entrar"),
    FECHAR("Fechar"),
    POSTAR("Postar"),
    TIMELINE("Visualizar sua Timeline"),
    SAIR("Sair");

    private final String descricao;
    OpcoesMenu (String descricao) {
        this.descricao = descricao;
    }

    public String toString() {
        return descricao;
    }
}
