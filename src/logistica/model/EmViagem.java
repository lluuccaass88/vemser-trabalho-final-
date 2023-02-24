package src.logistica.model;

import java.util.Arrays;

public enum EmViagem {
    ESTACIONADO(1),
    EM_VIAGEM(2);

    private Integer opcao;

    EmViagem(Integer opcao) { this.opcao = opcao; }

    public Integer getOpcao() { return opcao; }

    public static EmViagem getOpcaoEmViagem(Integer opcao) { // 1
        return Arrays.stream(EmViagem.values()) // [ESTACIONADO(1), EM_VIAGEM(2)]
                .filter(emViagem -> emViagem.getOpcao().equals(opcao)) // [ESTACIONADO(1)]
                .findFirst() // optional => ESTACIONADO(1)
                .get(); // ESTACIONADO(1)
    }
}