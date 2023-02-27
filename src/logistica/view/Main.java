package src.logistica.view;

import src.logistica.model.Usuario;
import src.logistica.service.CaminhaoService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Usuario usuarioLogado = new Usuario();

        Scanner scanner = new Scanner(System.in);

        CaminhaoMenu caminhaoMenu = new CaminhaoMenu();
        CaminhaoService caminhaoService = new CaminhaoService();
        RotaMenu rotaMenu = new RotaMenu();
        PostoMenu postoMenu = new PostoMenu();
        UsuarioMenu usuarioMenu = new UsuarioMenu();
        HomeMenu homeMenu = new HomeMenu();
        ViagemMenu viagemMenu = new ViagemMenu();

        int opcao = -1;

        usuarioLogado = homeMenu.MenuHome(); //Para logar ou cadastrar
        System.out.println("=== Bem vindo " + usuarioLogado.getNome() + " ===");

        if (usuarioLogado.getPerfil().getPerfil().equals(1)) {
            System.out.println("Acesso ao menu de Colaborador");
            while (opcao != 0) {
                System.out.println("""
                        =========MENU PRINCIPAL=========
                        Usuarios:        [1]
                        Caminhões:       [2]
                        Postos:          [3]
                        Rotas:           [4]
                        Sair do Sistema: [0]
                        Digite sua opção:\s""");
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1 -> {
                        System.out.println("Acessando o Menu de Usuários");
                        usuarioMenu.menuUsuario();
                    }
                    case 2 -> {
                        System.out.println("Acessando o Menu de Caminhões");
                        caminhaoMenu.menuCaminhao();
                    }
                    case 3 -> {
                        System.out.println("Acessando o Menu de Postos");
                        postoMenu.menuPosto();
                    }
                    case 4 -> {
                        System.out.println("Acessando o Menu de Rotas");
                        rotaMenu.menuRota();
                    }
                    case 0 -> {
                        System.out.println("Saindo do Sistema...");
                    }
                }
            }
        } else {
            System.out.println("Acesso ao menu de Motorista");
            while (opcao != 0) {
                System.out.println("""
                        =========MENU PRINCIPAL=========
                        Viagens:         [1]
                        Abastecimento:   [2]
                        Caminhoes:       [3]
                        Sair do Sistema: [0]
                        Digite sua opção:\s""");
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {

                    case 1 -> {
                        System.out.println("Acessando as viagens ... ");
                        viagemMenu.menuViagem(usuarioLogado);
                    }
                    case 2 -> {
                        System.out.println("Acessando o Menu de Abastecimento");
                        caminhaoService.listarCaminhoesLivres();
                        System.out.println("Informe a ID do caminhhão que deseja realizar abastecimento");
                        int index = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Abastecendo o caminhão " + index + " informando que o caminhão já tem + "
                                + caminhaoService.retornaPorId(index).getGasolina() + " % do seu tanque preenchido");
                        System.out.println("Informe a quantidade de gasolina (em %) que deseja abastecer:");
                        int gasolina = scanner.nextInt();
                        scanner.nextLine();
                        caminhaoService.abastecerCaminhao(index, gasolina);
                    }
                    case 3 -> {
                        System.out.println("Listando todos os caminhoes disponiveis para viagens");
                        caminhaoService.listarCaminhoesLivres();
                    }
                    case 0 -> {
                        System.out.println("Saindo do Sistema...");
                    }
                }
            }
        }
        scanner.close();
    }
}