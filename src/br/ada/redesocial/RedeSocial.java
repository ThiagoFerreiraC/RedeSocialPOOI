package br.ada.redesocial;

import br.ada.redesocial.exceptions.FieldIsBlankException;
import br.ada.redesocial.exceptions.InvalidPasswordException;
import br.ada.redesocial.exceptions.LoginInUseException;
import br.ada.redesocial.exceptions.UserNotFoundException;
import br.ada.redesocial.menu.Menu;
import br.ada.redesocial.menu.MenuInicial;
import br.ada.redesocial.menu.MenuUsuario;
import br.ada.redesocial.perfil.Perfil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class RedeSocial {
    private List<Perfil> perfis;
    private Perfil usuarioLogado;
    private static RedeSocial redeSocial;
    private RedeSocial() {
        perfis = new ArrayList<>();
        usuarioLogado = null;
    }

    public static RedeSocial getInstance() {
        if (redeSocial == null) {
            redeSocial = new RedeSocial();
        }
        return redeSocial;
    }

    public static void main(String[] args) {
        redeSocial = RedeSocial.getInstance();
        redeSocial.iniciarExecucaoPrograma();
    }

    public void iniciarExecucaoPrograma() {
        Menu menuInicial = new MenuInicial();
        menuInicial.exibir();
    }

    public void cadastrarUsuario() throws LoginInUseException, FieldIsBlankException{
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite o nome desejado: ");
        String nome = scan.nextLine();

        System.out.print("Digite o login desejado: ");
        String login = scan.nextLine();

        for (Perfil usuario : perfis) {
            if (login.equalsIgnoreCase(usuario.getLogin())) {
                throw new LoginInUseException();
            }
        }

        System.out.print("Crie uma senha: ");
        String senha = scan.nextLine();

        if (nome.isBlank() || senha.isBlank() || login.isBlank()) {
            throw new FieldIsBlankException();
        }

        Perfil usuario = new Perfil(nome, login, senha);

        perfis.add(usuario);
        System.out.println("Bem-vindo(a) ao Exemplário, " + usuario.getNome() +
                        ". Agora escolha a opção \"2 - Entrar\" para " +
                        "que você possa aproveitar da nossa rede. \n");
    }

    public void logarUsuario() throws UserNotFoundException, InvalidPasswordException {
            Scanner scan = new Scanner(System.in);
            System.out.print("Digite o login: ");
            String loginAConferir = scan.nextLine();

            encontrarUsuario(loginAConferir);

            if (usuarioLogado == null) {
                throw new UserNotFoundException();
            } else if (!usuarioLogado.isSenhaCorreta()) {
                throw new InvalidPasswordException();
            }
    }

    public void iniciarMenuUsuario() {
        System.out.println("\nBem-vindo(a), " + usuarioLogado.getNome() + ".");
        Menu menuUsuario = new MenuUsuario(usuarioLogado);
        menuUsuario.exibir();
    }
    private void encontrarUsuario(String loginAConferir) {
        for (Perfil usuario : perfis) {
            if (loginAConferir.equalsIgnoreCase(usuario.getLogin())) {
                int idUsuarioLogado = perfis.indexOf(usuario);
                usuarioLogado = perfis.get(idUsuarioLogado);
                break;
            }
        }
    }

    public void deslogarUsuario() {
        usuarioLogado = null;
    }
}


