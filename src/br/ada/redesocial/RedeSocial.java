package br.ada.redesocial;

import br.ada.redesocial.exceptions.InvalidPasswordException;
import br.ada.redesocial.exceptions.UserNotFoundException;
import br.ada.redesocial.menu.Menu;
import br.ada.redesocial.menu.MenuInicial;
import br.ada.redesocial.menu.MenuUsuario;
import br.ada.redesocial.perfil.Perfil;
import br.ada.redesocial.perfil.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class RedeSocial {
    public static Scanner scan = new Scanner(System.in);
    private List<Perfil> perfis;
    private static RedeSocial redeSocial = new RedeSocial();
    private Integer idUsuarioLogado;

    public static void main(String[] args) {
        RedeSocial redeSocial = new RedeSocial();
        redeSocial.iniciarExecucaoPrograma();
    }

    public RedeSocial() {
        perfis = new ArrayList<>();
        idUsuarioLogado = null;
    }
    public void iniciarExecucaoPrograma() {
        Menu menuInicial = new MenuInicial();
        menuInicial.executarMenu();
    }

    public void adicionarUsuario() {
        System.out.print("Digite o nome desejado: ");
        String nome = scan.nextLine();

        String login;
        do {
            System.out.print("Digite o login desejado: ");
            login = scan.nextLine().toUpperCase();
        } while (!isLoginUnico(login));

        System.out.print("Crie uma senha: ");
        String senha = scan.nextLine();

        if (nome.isBlank() || senha.isBlank() || login.isBlank()) {
            System.out.println("Nenhum dos campos pode ser vazio");
            redeSocial.iniciarExecucaoPrograma();
        }

        Perfil usuario = new Perfil(nome, login, senha);

        redeSocial.adicionarPerfil(usuario);
        System.out.println("Bem-vindo(a) ao Exemplário, " + usuario.getNome() +
                        ". Agora escolha a opção \"2 - Entrar\" para " +
                        "que você possa aproveitar da nossa rede.");
        redeSocial.iniciarExecucaoPrograma();
    }


    public void adicionarPerfil(Perfil usuario) {
        this.perfis.add(usuario);
    }

    public List<Perfil> getPerfis() {
        return this.perfis;
    }

    private boolean isLoginUnico(String login) {
        for (Perfil usuario : redeSocial.getPerfis()) {
            if (login.equals(usuario.getLogin())) {
                System.out.println("Esse login já está sendo utilizado. Por favor, escolha outro.");
                return false;
            }
        }
        return true;
    }

    public void fazerLogin() {
        boolean loginBemSucedido = true;

        try {
            encontrarUsuario();
            redeSocial.getUsuarioLogado().isSenhaCorreta();
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
            loginBemSucedido = false;
        } catch (InvalidPasswordException e) {
            System.out.println(e.getMessage());
            loginBemSucedido = false;
        }

        if (loginBemSucedido) {
            System.out.println("Bem-vindo(a), " + redeSocial.getUsuarioLogado().getNome() + ".");
            Menu menuUsuario = new MenuUsuario();
            menuUsuario.executarMenu();
        } else {
           iniciarExecucaoPrograma();
        }
    }

    private void encontrarUsuario() throws UserNotFoundException {
        boolean loginEncontrado = false;
        System.out.print("Digite o login: ");
        String loginAConferir = scan.nextLine().toUpperCase();
        List<Perfil> listaDeUsuarios = redeSocial.getPerfis();

        for (Perfil usuario : listaDeUsuarios) {
            if (loginAConferir.equals(usuario.getLogin())) {
                loginEncontrado = true;
                int idUsuario = listaDeUsuarios.indexOf(usuario);
                redeSocial.setIdUsuarioLogado(idUsuario);
                break;
            }
        }

        if (!loginEncontrado) {
            throw new UserNotFoundException();
        }
    }

    private void setIdUsuarioLogado(int idUsuarioLogado) {
        redeSocial.idUsuarioLogado = idUsuarioLogado;
    }

    private Perfil getUsuarioLogado() {
        return redeSocial.getPerfis().get(idUsuarioLogado);
    }

    public void postar() {
        redeSocial.getUsuarioLogado().postar();
    }

    public void exibirTimeline() {
        Perfil usuarioLogado = redeSocial.getUsuarioLogado();
        System.out.println("\nSua Timeline, " + usuarioLogado.getNome() + ":");
        boolean usuarioSemNenhumPost = usuarioLogado.getPosts().size() == 0;
        if (usuarioSemNenhumPost) {
            System.out.println("Você ainda não postou nada.");
        } else {
            for (Post post : usuarioLogado.getPosts()) {
                System.out.println(post.getData() + " às " + post.getHora() + " - " + post.getComentario());
            }
        }
    }
}


