package src.logistica.view;

import src.logistica.model.Perfil;
import src.logistica.model.Usuario;
import src.logistica.service.UsuarioService;

import java.util.Scanner;

public class HomeMenu {
    UsuarioService usuarioService = new UsuarioService();
    Usuario novoUsuario = new Usuario();
    int opcao = -1;
    Usuario usuarioLogado = new Usuario();
    String usuario, senha;

    public Usuario MenuHome() {
        Scanner sc = new Scanner(System.in);

        while (usuarioLogado.getId() == null) {
            System.out.println("""
                    ==========Bem vindo ao sistema de Logistica==========
                    Realizar Login:             [1]
                    Realizar Cadastro:          [2]
                    Digite sua opção:\s""");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1 -> {
                        System.out.println("Realizar Login: ");

                        System.out.println("Login: ");
                        usuario = sc.nextLine();

                        System.out.println("Senha: ");
                        senha = sc.nextLine();

                        usuarioLogado = usuarioService.loginUsuario(usuario, senha);
                }
                case 2 -> {
                    System.out.println("Cadastrando Usuário...");
                    System.out.println("Informe o seu nome:");
                    novoUsuario.setNome(sc.nextLine());

                    System.out.println("Informe o login de usuário:");
                    novoUsuario.setUsuario(sc.nextLine());

                    System.out.println("Informe a senha de usuário:");
                    novoUsuario.setSenha(sc.nextLine());

                    System.out.println("Informe o perfil: (1) Colaborador ou (2) Motorista");
                    novoUsuario.setPerfil(Perfil.ofTipoPerfil(sc.nextInt()));
                    sc.nextLine();

                    System.out.println("Informe o CPF do usuário: " + novoUsuario.getNome());
                    novoUsuario.setCpf(sc.nextLine());

                    System.out.println("Informe a CNH do usuário: " + novoUsuario.getNome());
                    novoUsuario.setCnh(sc.nextLine());

                    usuarioService.adicionarUsuario(novoUsuario);
                }
                case 0 -> {
                    System.out.println("Retornando ao Menu Principal");
                }
                default -> {
                    System.err.println("Opção inválida");
                }
            }
        }

        return usuarioLogado;
    }
}
