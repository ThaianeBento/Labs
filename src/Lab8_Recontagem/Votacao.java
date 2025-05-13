package Lab8_Recontagem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Votacao {
    private final List<String> votos;
    private final Map<String, Integer> contagemVotos = new HashMap<>();
    private int totalVotos = 0;

    public Votacao(List<String> votos){
        this.votos = votos;
        contarVotos();
    }

    private void contarVotos(){
        for(String nome : votos){
            contagemVotos.put(nome, contagemVotos.getOrDefault(nome,0)+1);
            totalVotos++;
        }
    }

    public String verificarResultado() {
        String vencedor = null;
        int votosVencedor = 0;
        int qtdEmpatadosNoTopo = 0;

        for (int qtdVotos : contagemVotos.values()) {
            if (qtdVotos > votosVencedor) {
                votosVencedor = qtdVotos;
            }
        }

        for (int qtdVotos : contagemVotos.values()) {
            if (qtdVotos == votosVencedor) {
                qtdEmpatadosNoTopo++;
            }
        }


        if (qtdEmpatadosNoTopo == 1) {
            for (Map.Entry<String, Integer> entry : contagemVotos.entrySet()) {
                if (entry.getValue() == votosVencedor) {
                    return entry.getKey();
                }
            }
        }

        return "Segundo turno!";
    }
}

