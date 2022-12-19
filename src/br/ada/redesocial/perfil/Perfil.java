package br.ada.redesocial.perfil;

import br.ada.redesocial.exceptions.FieldIsBlankException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Perfil {
    private final String nome;
    private final String login;
    private final String senha;
    private List<Post> posts;
    public Perfil(String nome, String login, String senha){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.posts = new ArrayList<>();
    }

    public String getLogin() {
        return login;
    }

    public String getNome() {
        return nome;
    }

    public void postar() throws FieldIsBlankException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite o comentário: ");
        String comentario = scan.nextLine();

        if(comentario.isBlank()) {
            throw new FieldIsBlankException();
        }

        posts.add( new Post(comentario));
        System.out.println("Post realizado com sucesso!");
    }

    public boolean isSenhaCorreta() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite a senha: ");
        String senhaAConferir = scan.nextLine();
        return senha.equals(senhaAConferir);
    }

    public void visualizarTimeline() {
        System.out.println("Sua Timeline, " + nome + ":");
        if (posts.size() == 0) {
            System.out.println("Você ainda não postou nada.");
        } else {
            for (Post post : posts) {
                System.out.println(post.getData() + " às " + post.getHora() + " - " + post.getComentario());
            }
        }
    }
}
