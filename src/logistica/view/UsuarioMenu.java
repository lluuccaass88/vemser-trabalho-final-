package src.logistica.view;

import src.logistica.model.Perfil;
import src.logistica.model.Usuario;
import src.logistica.service.UsuarioService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UsuarioMenu {

    UsuarioService usuarioService = new UsuarioService();
    Usuario usuario = new Usuario();

    public void menuUsuario() {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("""
                    ==========Menu Usuário==========
                    Cadastrar Usuário :         [1]
                    Listar Usuário:             [2]
                    Editar Usuário:             [3]
                    Excluir Usuário :           [4]
                    Retornar ao Menu Principal: [0]
                    Digite sua opção:\s""");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1 -> {
                    System.out.println("Cadastrando Usuário...");
                    System.out.println("Informe o seu nome:");
                    usuario.setNome(sc.nextLine());

                    System.out.println("Informe o login de usuário:");
                    usuario.setUsuario(sc.nextLine());

                    System.out.println("Informe a senha de usuário:");
                    usuario.setSenha(sc.nextLine());

                    System.out.println("Informe o perfil: (1) Colaborador ou (2) Motorista");
                    usuario.setPerfil(Perfil.ofTipoPerfil(sc.nextInt()));
                    sc.nextLine();

                    System.out.println("Informe o CPF do usuário: " + usuario.getNome());
                    usuario.setCpf(sc.nextLine());

                    System.out.println("Informe a CNH do usuário: " + usuario.getNome());
                    usuario.setCnh(sc.nextLine());

                    usuarioService.adicionarUsuario(usuario);
                }
                case 2 -> {
                    System.out.println("Listando Usuários...");
                    usuarioService.listarUsuarios();
                }
                case 3 -> {
                    System.out.println("Editando Usuário...");
                    System.out.println("Digite o ID do usuário que deseja editar:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Informe o seu nome:");
                    usuario.setNome(sc.nextLine());

                    System.out.println("Informe o login de usuário:");
                    usuario.setUsuario(sc.nextLine());

                    System.out.println("Informe a senha de usuário:");
                    usuario.setSenha(sc.nextLine());

                    System.out.println("Informe o perfil: (1) Colaborador ou (2) Motorista");
                    usuario.setPerfil(Perfil.ofTipoPerfil(sc.nextInt()));
                    sc.nextLine();

                    System.out.println("Informe o CPF do usuário: " + usuario.getNome());
                    usuario.setCpf(sc.nextLine());

                    System.out.println("Informe a CNH do usuário: " + usuario.getNome());
                    usuario.setCnh(sc.nextLine());

                    usuarioService.editarUsuarios(id, usuario);
                }
                case 4 -> {
                    System.out.println("Excluindo Usuário...");
                    usuarioService.listarUsuarios();
                    System.out.println("Digite o ID do usuário que deseja excluir:");
                    boolean validacao = false;
                    while (!validacao) {
                        try {
                            int id = sc.nextInt();
                            sc.nextLine();
                            usuarioService.removerUsuarios(id);
                            validacao = true;
                        } catch (InputMismatchException ex) {
                            System.err.println("Número inválido");
                        }
                    }
                }
                case 0 -> {
                    System.out.println("Retornando ao Menu Principal");
                }
                default -> {
                    System.err.println("Opção inválida");
                }
            }
        }
    }
}