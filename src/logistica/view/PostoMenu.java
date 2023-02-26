package src.logistica.view;

import src.logistica.model.Posto;
import src.logistica.service.PostoService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PostoMenu {

    PostoService postoService = new PostoService();
    Posto posto = new Posto();

    public void menuPosto() {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("""
                    ===============Menu Posto===============
                    Cadastrar Posto:             [1]
                    Listar Posto:                [2]
                    Editar Posto:                [3]
                    Excluir Posto:               [4]
                    Retornar ao Menu Principal:  [0]
                    Digite sua opção:\s""");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> { // cadastrando

                    System.out.println("Digite o nome do posto: ");
                    posto.setNomePosto(sc.nextLine());

                    System.out.println("Digite o valor do combustivel: ");
                    posto.setValorCombustivel(sc.nextDouble());
                    sc.nextLine();

                    postoService.adicionaPosto(posto);

                }
                case 2 -> { // listando
                    postoService.listarPosto();
                }
                case 3 -> { // editando
                    System.out.println("Digite o id do posto para editar: ");
                    int id = sc.nextInt();

                    System.out.println("Digite o nome do posto: ");
                    posto.setNomePosto(sc.nextLine());

                    System.out.println("Digite o valor do combustivel: ");
                    posto.setValorCombustivel(sc.nextDouble());
                    sc.nextLine();

                    postoService.editarPosto(id, posto);
                }
                case 4 -> { // excluindo
                    System.out.println("Digite do id do posto para excluir: ");
                    boolean validacao = false;
                    while (!validacao) {
                        try {
                            int id = sc.nextInt();
                            sc.nextLine();
                            postoService.removerPosto(id);
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