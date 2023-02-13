import java.util.Scanner;
public class Main {

    public static void opcoesMotorista(ManipulaMotorista manipulaMotorista, int primeiroCadastro){
        String nome, cpf, cnh, credencial;
        int idade, opcMotorista, idMotorista;
        double salario;

        Scanner leitorUsuario = new Scanner(System.in);

        if(primeiroCadastro == 1){
            opcMotorista = 1;
        }else{
            System.out.println("""
                ===============Opções Motorista===============
                Cadastrar Motorista: [1]
                Ver Motoristas:      [2]
                Editar Motorista:    [3]
                Excluir Motorista:   [4]
                Digite sua opção:\s""");

            opcMotorista = leitorUsuario.nextInt();
            leitorUsuario.nextLine();
        }

        switch (opcMotorista){
            case 1:
                System.out.println("============== Cadastro de motorista ==============");
                System.out.println("\nNome: ");
                nome = leitorUsuario.nextLine();
                System.out.println("\ncpf: ");
                cpf = leitorUsuario.nextLine();
                System.out.println("\nCNH: ");
                cnh = leitorUsuario.nextLine();
                System.out.println("\nIdade: ");
                idade = leitorUsuario.nextInt();
                leitorUsuario.nextLine();
                System.out.println("\nSalario: ");
                salario = leitorUsuario.nextDouble();
                leitorUsuario.nextLine();

                Motorista motorista = new Motorista(nome, cpf, salario, idade, cnh);
                manipulaMotorista.adicionaMotorista(motorista);

                break;
            case 2:
                manipulaMotorista.listarMotoristas();
                break;
            case 3:
                System.out.println("Digite o id do motorista que deseja editar: ");
                idMotorista = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                System.out.println("\nNome: ");
                nome = leitorUsuario.nextLine();
                System.out.println("\ncpf: ");
                cpf = leitorUsuario.nextLine();
                System.out.println("\nCNH: ");
                cnh = leitorUsuario.nextLine();
                System.out.println("\nIdade: ");
                idade = leitorUsuario.nextInt();
                leitorUsuario.nextLine();
                System.out.println("\nSalario: ");
                salario = leitorUsuario.nextDouble();
                leitorUsuario.nextLine();

                Motorista motoristaEditado = new Motorista(nome, cpf, salario, idade, cnh);

                manipulaMotorista.editarMotorista(idMotorista, motoristaEditado);
                break;
            case 4:
                System.out.println("Digite o id do motorista que deseja excluir");
                idMotorista = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                manipulaMotorista.removerMotoristaPorIndice(idMotorista);
        }
    }

    public static void opcoesCaminhao(ManipulaCaminhao manipulaCaminhao, ManipulaPosto manipulaPosto) {
        Scanner leitorUsuario = new Scanner(System.in);
        int opcCaminhao, gasolina, idCaminhao, idPosto, quantidadeGasolina;
        String placa, modelo, marca;
        double capacidade, kmRodados;

        System.out.println("""
                ===============Opções Caminhões===============
                Cadastrar Caminhão: [1]
                Ver Caminhão:       [2]
                Editar Caminhão:    [3]
                Excluir Caminhão:   [4]
                Abastecer           [5]
                Digite sua opção:\s""");

        opcCaminhao = leitorUsuario.nextInt();
        leitorUsuario.nextLine();

        switch (opcCaminhao) {
            case 1:
                System.out.println("============== Cadastro de caminhão ==============");
                System.out.println("\nPlaca: ");
                placa = leitorUsuario.nextLine();
                System.out.println("\nModelo: ");
                modelo = leitorUsuario.nextLine();
                System.out.println("\nMarca: ");
                marca = leitorUsuario.nextLine();
                System.out.println("\nCapacidade: ");
                capacidade = leitorUsuario.nextDouble();
                leitorUsuario.nextLine();
                System.out.println("\nQuilometros Rodados: ");
                kmRodados = leitorUsuario.nextDouble();
                leitorUsuario.nextLine();
                System.out.println("\nQuantidade de gasolina ( de 0 a 100 ): ");
                gasolina = leitorUsuario.nextInt();
                while (gasolina > 100 || gasolina < 0 ){
                    System.out.println("Porfavor digitar um numero entre 0 e 100: ");
                    gasolina = leitorUsuario.nextInt();
                }
                leitorUsuario.nextLine();

                Caminhao caminhao = new Caminhao(placa, modelo, marca, capacidade, kmRodados, gasolina);
                manipulaCaminhao.adicionaCaminhao(caminhao);

                break;
            case 2:
                manipulaCaminhao.listarCaminhao();
                break;
            case 3:
                System.out.println("Digite o id do caminhão que deseja editar: ");
                idCaminhao = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                System.out.println("\nPlaca: ");
                placa = leitorUsuario.nextLine();
                System.out.println("\nModelo: ");
                modelo = leitorUsuario.nextLine();
                System.out.println("\nMarca: ");
                marca = leitorUsuario.nextLine();
                System.out.println("\nCapacidade: ");
                capacidade = leitorUsuario.nextDouble();
                leitorUsuario.nextLine();
                System.out.println("\nQuilometros Rodados: ");
                kmRodados = leitorUsuario.nextDouble();
                leitorUsuario.nextLine();
                System.out.println("\nQuantidade de gasolina ( de 0 a 100 ): ");
                gasolina = leitorUsuario.nextInt();
                while (gasolina > 100 || gasolina < 0 ){
                    System.out.println("Porfavor digitar um numero entre 0 e 100: ");
                    gasolina = leitorUsuario.nextInt();
                }
                leitorUsuario.nextLine();


                Caminhao caminhaoEditado = new Caminhao(placa, modelo, marca, capacidade, kmRodados, gasolina);

                manipulaCaminhao.editarCaminhao(idCaminhao, caminhaoEditado);

                break;
            case 4:
                System.out.println("Digite o id do motorista que deseja excluir");
                idCaminhao = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                manipulaCaminhao.removerCaminhaoroPorIndice(idCaminhao);
            case 5:
                System.out.println("===== Abastecimento ======\n");
                System.out.println("Digite o id do caminhão que deseja abastecer: ");
                if(manipulaPosto.retornaPosto().size() == 0){
                    System.out.println("Não há caminhões cadastrados no momento, retornando ao menu principal!");
                    break;
                }

                manipulaCaminhao.listarCaminhao();
                idCaminhao = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                System.out.println("Digite o id do posto que deseja abastecer: ");
                if(manipulaPosto.retornaPosto().size() == 0){
                    System.out.println("Não há postos cadastrados, retornando ao menu principal!");
                    break;
                }

                manipulaPosto.listarPostosCredenciados();
                idPosto = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                System.out.println("Digita a quantidade que deseja abastecer (1 a 100): ");
                quantidadeGasolina = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                Posto postoBuscado = manipulaPosto.buscaPostosCredenciadosID(idPosto);
                Caminhao caminhaoBuscado = manipulaCaminhao.buscaCaminhaoPorId(idCaminhao);



                caminhaoBuscado.abastecer(postoBuscado, quantidadeGasolina);
            break;

        }
    }

    public static void opcoesPosto(ManipulaPosto manipulaPosto) {
        Scanner leitorUsuario = new Scanner(System.in);
        int idPosto, opcPosto;
        String nome;
        double valorCombustivel;


        System.out.println("""
                ===============Opções Posto===============
                Cadastrar Posto: [1]
                Ver Postos:      [2]
                Editar Posto:    [3]
                Excluir Posto:   [4]
                Digite sua opção:\s""");

        opcPosto = leitorUsuario.nextInt();
        leitorUsuario.nextLine();

        switch (opcPosto) {
            case 1:
                System.out.println("============== Cadastro de Posto ==============");
                System.out.println("\nNome: ");
                nome = leitorUsuario.nextLine();
                System.out.println("\nValor do Combustivel: ");
                valorCombustivel = leitorUsuario.nextDouble();
                leitorUsuario.nextLine();

                Posto posto = new Posto(nome, valorCombustivel);
                manipulaPosto.adicionaPosto(posto);

                break;
            case 2:
                manipulaPosto.listarPostosCredenciados();
                break;
            case 3:
                System.out.println("Digite o id do posto de gasolina que deseja editar: ");
                idPosto = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                System.out.println("\nNome: ");
                nome = leitorUsuario.nextLine();
                System.out.println("\nValor do Combustivel: ");
                valorCombustivel = leitorUsuario.nextDouble();
                leitorUsuario.nextLine();

                Posto postoEditado = new Posto(nome, valorCombustivel);

                manipulaPosto.editarPosto(idPosto, postoEditado);

                break;
            case 4:
                System.out.println("Digite o id do posto de gasolina que deseja excluir");
                idPosto = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                manipulaPosto.removerPostoPorIndice(idPosto);
                break;
        }
    }

    public static void opcoesRota(ManipulaRotas manipulaRotas) {
        Scanner leitorUsuario = new Scanner(System.in);
        int idPRota, opcRota;
        String nome,descricao, localPartida, destino;


        System.out.println("""
                ===============Opções Rotas===============
                Cadastrar Rotas: [1]
                Ver Rotas:      [2]
                Editar Rota:    [3]
                Excluir Rota:   [4]
                Digite sua opção:\s""");

        opcRota = leitorUsuario.nextInt();
        leitorUsuario.nextLine();

        switch (opcRota) {
            case 1:
                System.out.println("============== Cadastro de Rota ==============");

                System.out.println("\nNome: ");
                nome = leitorUsuario.nextLine();
                System.out.println("\ndescricao: ");
                descricao = leitorUsuario.nextLine();
                System.out.println("\nLocal Partida: ");
                localPartida = leitorUsuario.nextLine();
                System.out.println("\nDestino: ");
                destino = leitorUsuario.nextLine();;

                Rota rota = new Rota(nome,descricao, localPartida, destino);
                manipulaRotas.adicionaRota(rota);
                break;
            case 2:
                manipulaRotas.listarRotas();
                break;
            case 3:
                System.out.println("Digite o id da rota que deseja editar: ");
                idPRota = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                System.out.println("\nNome: ");
                nome = leitorUsuario.nextLine();
                System.out.println("\ndescricao: ");
                descricao = leitorUsuario.nextLine();
                System.out.println("\nLocal Partida: ");
                localPartida = leitorUsuario.nextLine();
                System.out.println("\nDestino: ");
                destino = leitorUsuario.nextLine();;

                Rota rotaEditada = new Rota(nome,descricao, localPartida, destino);
                manipulaRotas.editarRota(idPRota, rotaEditada);
                break;
            case 4:
                System.out.println("Digite o id da rota que deseja excluir");
                idPRota = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                manipulaRotas.removerRotaPorIndice(idPRota);
                break;
        }
    }

    public static void opcoesColaborador(ManipulaColaborador manipulaColaborador, int primeiroCadastro, ManipulaMotorista manipulaMotorista) {
        String nome, cpf, rg;
        int idade, opcColaborador, idColaborador;
        double salario, aumentoSalario;

        Scanner leitorUsuario = new Scanner(System.in);

        if (primeiroCadastro == 1) {
            opcColaborador = 1;
        } else {
            System.out.println("""
                    ===============Opções Colaborador===============
                    Cadastrar colaborador: [1]
                    Ver colaborador:       [2]
                    Editar colaborador:    [3]
                    Excluir colaborador:   [4]
                    Aumento:               [5] 
                    Digite sua opção:\s""");

            opcColaborador = leitorUsuario.nextInt();
            leitorUsuario.nextLine();
        }

        switch (opcColaborador) {
            case 1:
                System.out.println("============== Cadastro de colaborador ==============");
                System.out.println("\nNome: ");
                nome = leitorUsuario.nextLine();
                System.out.println("\ncpf: ");
                cpf = leitorUsuario.nextLine();
                System.out.println("\nRG: ");
                rg = leitorUsuario.nextLine();
                System.out.println("\nIdade: ");
                idade = leitorUsuario.nextInt();
                leitorUsuario.nextLine();
                System.out.println("\nSalario: ");
                salario = leitorUsuario.nextDouble();
                leitorUsuario.nextLine();

                Colaborador colaborador = new Colaborador(nome, cpf, salario, idade, rg);
                manipulaColaborador.adicionaColaborador(colaborador);
                break;
            case 2:
                manipulaColaborador.listarColaboradores();
                break;
            case 3:
                System.out.println("Digite o id do Colavborador que deseja editar: ");
                idColaborador = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                System.out.println("\nNome: ");
                nome = leitorUsuario.nextLine();
                System.out.println("\ncpf: ");
                cpf = leitorUsuario.nextLine();
                System.out.println("\nRG: ");
                rg = leitorUsuario.nextLine();
                System.out.println("\nIdade: ");
                idade = leitorUsuario.nextInt();
                leitorUsuario.nextLine();
                System.out.println("\nSalario: ");
                salario = leitorUsuario.nextDouble();
                leitorUsuario.nextLine();

                Colaborador colaboradorEditado = new Colaborador(nome, cpf, salario, idade, rg);

                manipulaColaborador.editarColaborador(idColaborador, colaboradorEditado);
                break;
            case 4:
                System.out.println("Digite o id do colaborador que deseja excluir");
                idColaborador = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                manipulaColaborador.removerColaboradorPorIndice(idColaborador);
                break;
            case 5:
                System.out.println("Digite para quem você deseja dar o aumento: ");
                System.out.println("[1] Colaborador;");
                System.out.println("[2] Motorista;");
                opcColaborador = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                if(opcColaborador == 1){
                    System.out.println("Digite o id do colaborador que você deseja dar o aumento: ");
                    manipulaColaborador.listarColaboradores();
                    opcColaborador = leitorUsuario.nextInt();
                    leitorUsuario.nextLine();

                    System.out.println("Valor do aumento: ");
                    aumentoSalario = leitorUsuario.nextDouble();
                    leitorUsuario.nextLine();

                    manipulaColaborador.aumento(opcColaborador, aumentoSalario);
                }else if (opcColaborador == 2){
                    System.out.println("Digite o id do motorista que você deseja dar o aumento: ");
                    manipulaMotorista.listarMotoristas();
                    opcColaborador = leitorUsuario.nextInt();
                    leitorUsuario.nextLine();

                    System.out.println("Valor do aumento: ");
                    aumentoSalario = leitorUsuario.nextDouble();
                    leitorUsuario.nextLine();

                    manipulaMotorista.aumento(opcColaborador, aumentoSalario);
                }

                break;
        }
    }

    public static void opcoesViagem(ManipulaViagem manipulaViagem, ManipulaMotorista manipulaMotorista, ManipulaCaminhao manipulaCaminhao, ManipulaRotas manipulaRota, ManipulaPosto manipulaPosto) {
        Scanner leitorUsuario = new Scanner(System.in);
        int idViagem, opcViagem, idObjeto, quantidadeGasolina;
        Caminhao caminhao;
        Motorista motorista;
        Rota rota;

        System.out.println("""
                ===============Opções Viagens===============
                Cadastrar Viagem: [1]
                Ver Viagens:      [2]
                Editar Viagem:    [3]
                Excluir Viagem:   [4]
                Finalizar viagem: [5]
                Listar viagem fibalizada: [6]
                Digite sua opção:\s""");

        opcViagem = leitorUsuario.nextInt();
        leitorUsuario.nextLine();

        switch (opcViagem) {
            case 1:
                System.out.println("============== Cadastro de Viagem ==============");

                System.out.println("\nDigite o id do caminhão disponivel: ");
                if(manipulaCaminhao.caminhoesLivres().size() > 0) {
                    manipulaCaminhao.listarCaminhaoDisponivel();
                    idObjeto = leitorUsuario.nextInt();
                    leitorUsuario.nextLine();
                }else {
                    System.out.println("Não temos caminhões disponiveis no momento!");
                    break;
                }

                caminhao = manipulaCaminhao.buscaCaminhaoPorId(idObjeto);

                System.out.println("\nDigite o id do motorista disponivel: ");
                if(manipulaMotorista.motoristasLivres().size() > 0) {
                    manipulaMotorista.listarMotoristaDisponiveis();
                    idObjeto = leitorUsuario.nextInt();
                    leitorUsuario.nextLine();
                }else {
                    System.out.println("Não temos motoristas disponiveis no momento!");
                    break;
                }

                motorista = manipulaMotorista.buscaMotoristaPorId(idObjeto);


                System.out.println("\nDigite o id da rota: ");
                if(manipulaCaminhao.caminhoesLivres().size() > 0) {
                    manipulaRota.listarRotas();
                    idObjeto = leitorUsuario.nextInt();
                    leitorUsuario.nextLine();

                }else {
                    System.out.println("Não temos rotas cadastradas!");
                    break;
                }

                rota = manipulaRota.buscaRotaoPorId(idObjeto);

                Viagem viagem = new Viagem(caminhao, motorista, rota);
                caminhao.setEmViagem(true);
                motorista.setEmViagem(true);
                manipulaViagem.adicionaViagem(viagem);

            case 2:
                manipulaViagem.listarViagens();
                break;
            case 3:
                System.out.println("=========== Editar Viagem ===========");

                System.out.println("Digite o id da viagem que deseja editar (apenas viagens em andamento): ");
                manipulaViagem.listarViagensEmAndamento();
                idViagem = leitorUsuario.nextInt(); //Tem que verificar se a viagem é uma que esta em andamento, se sim ai continua a execuão, se não ele não continua.
                leitorUsuario.nextLine();

                System.out.println("\nDigite o id do caminhão disponivel: ");
                if(manipulaCaminhao.caminhoesLivres().size() > 0) {
                    manipulaCaminhao.listarCaminhaoDisponivel();

                }else {
                    System.out.println("Não temos caminhões disponiveis no momento!");
                }
                idObjeto = leitorUsuario.nextInt();
                leitorUsuario.nextLine();
                caminhao = manipulaCaminhao.buscaCaminhaoPorId(idObjeto);


                System.out.println("\nDigite o id do motorista disponivel: ");
                if(manipulaMotorista.motoristasLivres().size() > 0) {
                    manipulaMotorista.listarMotoristaDisponiveis();
                }else {
                    System.out.println("Não temos motoristas disponiveis no momento!");
                }
                idObjeto = leitorUsuario.nextInt();
                leitorUsuario.nextLine();
                motorista = manipulaMotorista.buscaMotoristaPorId(idObjeto);


                System.out.println("\nDigite o id da rota: ");
                if(manipulaCaminhao.caminhoesLivres().size() > 0) {
                    manipulaRota.listarRotas();
                }else {
                    System.out.println("Não temos rotas cadastradas!");
                }
                idObjeto = leitorUsuario.nextInt();
                leitorUsuario.nextLine();
                rota = manipulaRota.buscaRotaoPorId(idObjeto);


                Viagem viagemEditada = new Viagem(caminhao, motorista, rota);
                caminhao.setEmViagem(true);
                motorista.setEmViagem(true);

                manipulaViagem.editarViagem(idViagem, viagemEditada);
                break;
            case 4:
                System.out.println("Digite o id da viagem que deseja excluir");
                idViagem = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                manipulaViagem.removerViagemPorIndice(idViagem);
                break;
            case 5:
                System.out.println("Digite o id da viagem: ");
                manipulaViagem.listarViagensEmAndamento();
                idViagem = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

                Viagem viagemBuscada2 = manipulaViagem.BuscaViagensId(idViagem);
                viagemBuscada2.finalizarViagem();
                System.out.println("Viagem finalizada com sucesso!");
                break;
            case 6:
                manipulaViagem.listarViagensRealizadas();
                break;
        }
    }

        public static void main (String[]args){
            ManipulaMotorista manipulaMotorista = new ManipulaMotorista();
            ManipulaCaminhao manipulaCaminhao = new ManipulaCaminhao();
            ManipulaPosto manipulaPosto = new ManipulaPosto();
            ManipulaRotas manipulaRota = new ManipulaRotas();
            ManipulaViagem manipulaViagem = new ManipulaViagem();
            ManipulaColaborador manipulaColaborador = new ManipulaColaborador();

            int opc = -1;
            int idMotorista, idColaborador;
            boolean isColaborador = false;
            Scanner leitorUsuario = new Scanner(System.in);

            while (opc != 0) { //Laço do programa


                while (opc != -2){ //laço sem login
                    System.out.println("========== Escolha sua opção: ==========");
                    System.out.println("[1] Entrar como colaborador");
                    System.out.println("[2] Entrar como motorista");
                    opc = leitorUsuario.nextInt();
                    leitorUsuario.nextLine();


                    switch (opc){
                        case 1:
                            if(manipulaColaborador.retornaListaColaboradores().size() == 0) {
                                System.out.println("O sistema não possui nem um colaborador cadastrado. ");
                                opcoesColaborador(manipulaColaborador, 1, manipulaMotorista);
                            }else{
                                System.out.println("Digite a id da sua conta de colaborador: ");

                                idColaborador = leitorUsuario.nextInt();
                                leitorUsuario.nextLine();

                                if(manipulaColaborador.buscaColaboradorId(idColaborador) != null){
                                    System.out.println("Login efetuado! ");
                                }
                            }
                            isColaborador = true;
                            opc = -2;
                            break;
                        case 2:
                            if(manipulaMotorista.retornaListaMotorista().size() == 0){
                                System.out.println("O sistema não possui nem um caminhoneiro cadastrado. ");
                            }else{
                                System.out.println("Digite a id da sua conta de motorista: ");

                                idMotorista = leitorUsuario.nextInt();
                                leitorUsuario.nextLine();

                                if(manipulaMotorista.buscaMotoristaPorId(idMotorista) != null){
                                    System.out.println("Login efetuado! ");
                                }
                                isColaborador = false;
                                opc = -2;
                            }
                            break;
                    }
                }

                if(isColaborador){
                    while (opc != -3){
                        System.out.println("========== Escolha sua opção ==========");
                        System.out.println("[1] Opções de motorista");
                        System.out.println("[2] Opções do caminhão");
                        System.out.println("[3] Opções de Posto de gasolina");
                        System.out.println("[4] Opções de rotas");
                        System.out.println("[5] Opções de colaboradores");
                        System.out.println("[9] Sair da conta");

                        opc = leitorUsuario.nextInt();
                        leitorUsuario.nextLine();

                        switch (opc) {
                            case 1:
                                opcoesMotorista(manipulaMotorista, 0);
                                break;
                            case  2:
                                opcoesCaminhao(manipulaCaminhao, manipulaPosto);
                                break;
                            case 3:
                                opcoesPosto(manipulaPosto);
                                break;
                            case 4:
                                opcoesRota(manipulaRota);
                                break;
                            case 5:
                                opcoesColaborador(manipulaColaborador, 0, manipulaMotorista);
                                break;
                            case 9:
                                opc = -3;
                                break;
                        }
                    }
                }else{
                    while (opc != -3){
                        System.out.println("========== Escolha sua opção ==========");
                        System.out.println("[1] Opções de viagem");
                        System.out.println("[9] Sair da conta");

                        opc = leitorUsuario.nextInt();
                        leitorUsuario.nextLine();

                        switch (opc) {
                            case 1:
                                opcoesViagem(manipulaViagem, manipulaMotorista, manipulaCaminhao, manipulaRota, manipulaPosto);
                                break;
                            case 9:
                                opc = -3;
                                break;
                        }

                    }
                }

                System.out.println("[0] Fechar programa");
                System.out.println("[1] Continuar");
                opc = leitorUsuario.nextInt();
                leitorUsuario.nextLine();

            }


        }
    }

