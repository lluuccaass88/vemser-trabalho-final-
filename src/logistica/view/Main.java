package src.logistica.view;

import src.logistica.model.Usuario;
import src.logistica.service.UsuarioService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Usuario usuarioLogado = new Usuario();

        Scanner scanner = new Scanner(System.in);

        CaminhaoMenu caminhaoMenu = new CaminhaoMenu();
        RotaMenu rotaMenu = new RotaMenu();
        UsuarioMenu usuarioMenu = new UsuarioMenu();
        HomeMenu homeMenu = new HomeMenu();
        ViagemMenu viagemMenu = new ViagemMenu();

        int opcao = -1;

        usuarioLogado = homeMenu.MenuHome(); //Para logar ou cadastrar

        System.out.println("=== Bem vindo " + usuarioLogado.getNome() + " ===");

        while (opcao != 0) {
            System.out.println("""
                    =========MENU PRINCIPAL=========
                    Usuarios:        [1]
                    Caminhões:       [2]
                    Postos:          [3]
                    Rotas:           [4]
                    Viagens:         [5]
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
                }
                case 4 -> {
                    System.out.println("Acessando o Menu de Rotas");
                    rotaMenu.menuRota();
                }
                case 5 -> {
                    System.out.println("Acessando o Menu de Viagens");
                    viagemMenu.menuUsuario(usuarioLogado);
                }
                case 0 -> {
                    System.out.println("Saindo do Sistema...");
                }
            }
        }
        scanner.close();
    }
}