package src.logistica.view;

import src.logistica.model.Viagem;
import src.logistica.service.ViagemService;

import java.util.Scanner;

public class ViagemMenu {
    ViagemService viagemService = new ViagemService();
    Viagem viagem = new Viagem();

    public void menuViagem() {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("""
                    ==========Menu Viagem==========
                    Cadastrar Viagem :          [1]
                    Listar Viagens:             [2]
                    Editar Viagem:              [3]
                    Excluir Viagem :            [4]
                    Retornar ao Menu Principal: [0]
                    Digite sua opção:\s""");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1 -> {
                    System.out.println("Listando Caminhões Livres para Viagem..");
                    viagemService.adicionar;


                    //                    usuario.setNome(sc.nextLine());



//                    System.out.println("Informe o login de usuário:");
//                    usuario.setUsuario(sc.nextLine());
//
//                    System.out.println("Informe a senha de usuário:");
//                    usuario.setSenha(sc.nextLine());
//
//                    System.out.println("Informe o perfil: (1) Colaborador ou (2) Motorista");
//                    usuario.setPerfil(Perfil.ofTipoPerfil(sc.nextInt()));
//                    sc.nextLine();
//
//                    System.out.println("Informe o CPF do usuário: " + usuario.getNome());
//                    usuario.setCpf(sc.nextLine());
//
//                    System.out.println("Informe a CNH do usuário: " + usuario.getNome());
//                    usuario.setCnh(sc.nextLine());
//
//                    usuarioService.adicionarUsuario(usuario);
                }
                case 2 -> {
                    viagemService.listarViagens();
                }
                case 3 -> {

                }
                case 4 -> {

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
