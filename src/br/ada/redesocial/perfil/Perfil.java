package br.ada.redesocial.perfil;

import br.ada.redesocial.exceptions.InvalidPasswordException;

import java.util.ArrayList;
import java.util.List;

import static br.ada.redesocial.RedeSocial.scan;

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

    public void postar() {
        System.out.println("\n----POSTAR");
        System.out.print("Digite o comentário: ");
        String comentario = scan.nextLine();

        if(comentario.isBlank()) {
            System.out.println("Comentário não pode ser em branco");
            postar();
        }

        Post post = new Post(comentario);
        this.adicionarPost(post);
        System.out.println("Post realizado com sucesso!");
    }

    private void adicionarPost(Post post) {
        this.posts.add(post);
    }
    public List<Post> getPosts() {
        return posts;
    }

    public void isSenhaCorreta() throws InvalidPasswordException {
        System.out.print("Digite a senha: ");
        String senhaAConferir = scan.nextLine();

        if (!senha.equals(senhaAConferir)) {
            throw new InvalidPasswordException();
        }
    }

}
