package Lab8_Recontagem;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> votos = LeitorEntrada.lerVotos();
        Votacao votacao = new Votacao (votos);
        String resultado = votacao.verificarResultado ();

        System.out.println(resultado);
    }
}
